import java.sql.{Connection, DriverManager, ResultSet}

/**
  * Created by yangyibo on 16/11/23.
  */
object DB {

  def main(args: Array[String]) {


    /**
      *
      *
      * dev_select
      *
      * OdQ71bFMkxtfKi5HYz
      *
      * 3306
      *
      * 理财数仓
      *
      * 172.20.10.39外网查询权限
      *
      *
      * */

    val user = "dev_select"
    val password = "OdQ71bFMkxtfKi5HYz"
    val host = "172.20.10.39"
    val database = "hexindai_dis"
    val conn_str = "jdbc:mysql://" + host + ":3306/" + database + "?user=" + user + "&password=" + password
    println(conn_str)
    val conn = connect(conn_str)
    val statement =conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    // Execute Query
    val rs = statement.executeQuery("select * from t02_mortgage_car")
    // Iterate Over ResultSet
    while (rs.next) {
      // 返回行号
      // println(rs.getRow)
      val name = rs.getString("model")
      println(name)
    }
    closeConn(conn)
  }

  def connect(conn_str: String): Connection = {
    //classOf[com.mysql.jdbc.Driver]
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    return  DriverManager.getConnection(conn_str)
  }

  def closeConn(conn:Connection): Unit ={
    conn.close()
  }

}