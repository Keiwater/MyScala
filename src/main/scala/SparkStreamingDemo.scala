import java.sql.{DriverManager, ResultSet}

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable.Queue

/**
  * Created by yangyibo on 16/11/23.
  */
object SparkStreamingDemo {
  def main(args: Array[String]) {

    //创建spark实例
    val sparkConf = new SparkConf().setAppName("QueueStream")
    sparkConf.setMaster("local")
    // 创建sparkStreamingContext ，Seconds是多久去Rdd中取一次数据。
    val ssc = new StreamingContext(sparkConf, Seconds(3))

    // Create the queue through which RDDs can be pushed to a QueueInputDStream
    var rddQueue = new Queue[RDD[String]]()
    // 从rdd队列中读取输入流
    val inputStream = ssc.queueStream(rddQueue)
    //将输入流中的每个元素（每个元素都是一个String）后面添加一个“a“字符，并返回一个新的rdd。
    val mappedStream = inputStream.map(x => (x + "a", 1))
    //reduceByKey(_ + _)对每个元素统计次数。map(x => (x._2,x._1))是将map的key和value 交换位置。后边是过滤次数超过1次的且String 相等于“testa“
    val reducedStream = mappedStream.reduceByKey(_ + _)
      .map(x => (x._2,x._1)).filter((x)=>x._1>1).filter((x)=>x._2.equals("testa"))
    reducedStream.print()
    //将每次计算的结果存储在./out/resulted处。
    reducedStream.saveAsTextFiles("./out/resulted")
    ssc.start()

    //从数据库中查出每个用户的姓名，返回的是一个String有序队列seq，因为生成RDD的对象必须是seq。
    val seq = conn()
    println(Seq)
    //将seq生成RDD然后放入Spark的Streaming的RDD队列，作为输入流。
    for (i <- 1 to 3) {

      rddQueue.synchronized {
        rddQueue += ssc.sparkContext.makeRDD(seq,10)
      }
      Thread.sleep(3000)
    }
    ssc.stop()
  }


  //从数据库中取出每个用户的名字，是个String有序队列
  def conn(): Seq[String] = {
    val user = "dev_select"
    val password = "OdQ71bFMkxtfKi5HYz"
    val host = "172.20.10.39"
    val database = "hexindai_dis"
    val conn_str = "jdbc:mysql://" + host + ":3306/" + database + "?user=" + user + "&password=" + password
    //classOf[com.mysql.jdbc.Driver]
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    val conn = DriverManager.getConnection(conn_str)
    var setName = Seq("")
    try {
      // Configure to be Read Only
      val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)

      // Execute Query，查询用户表 sec_user 是我的用户表，有name属性。
      val rs = statement.executeQuery("select * from t02_mortgage_car")
      // Iterate Over ResultSet

      while (rs.next) {
        // 返回行号
        // println(rs.getRow)
        val name = rs.getString("model")
        setName = setName :+ name
      }
      return setName
    }
    finally {
      conn.close
    }
  }
}