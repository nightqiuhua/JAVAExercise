package atguigu.senior.day15;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBCTest4 {
    public static void main(String[] args) {

    }

/**
 * 向数据库的数据表中插入10w条记录
 * 测试如何插入，用时最短
 * 2. 使用PreparedStatement：13131
 * 3. 在2的基础上使用批量处理：24596?这就很尴尬了
 */
     public static void testPrepareStatement(){
         Connection conn = null;
         PreparedStatement ps = null;
         String sql = null;

         try{
             conn = JDBCTools.getConnection();
             sql = "insert into temps(id, temp) values(?,?)";
             ps = conn.prepareStatement(sql);
             for(int i=0;i<10000;i++){
                 ps.setString(1,"sensor_"+i);
                 ps.setString(2,"666666");
                 ps.executeUpdate();

                 // “积攒”sql语句
                 ps.addBatch();;
                 // 当积攒到一定程度，就统一地执行一次，并且清空先前积攒的sql
                 if((i + 1) % 300 == 0){
                     ps.executeBatch();
                     ps.clearBatch();
                 }
             }

             // 若总条数不是批量数值的整数倍，则还需要额外再执行一次
             if(100000 % 300 != 0){
                 ps.executeBatch();
                 ps.clearBatch();
             }

             JDBCTools.commit(conn);

         } catch (Exception e){
             e.printStackTrace();
             JDBCTools.rollback(conn);
         }finally {
             JDBCTools.release(null,ps,conn);
         }
     }

}
