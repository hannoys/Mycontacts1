package cn.edu.gdmec.a07150817.mycontacts1;

import android.content.ContentValues;
import android.content.Context;

/**
 * Created by ys on 2016/10/23.
 */
public class ContactsTable {
    //数据库表名字常量
    private final static String TABLENAME = "contactsTable";
    //声明数据库对象
    private MyDB db;
    //构造方法
    public ContactsTable(Context context){
        //创建MyDB对象 context很重要？context是什么？内容物？
        db = new MyDB(context);
        //如果数据表不存在则新疆数据表
        //是不是要调用一下MyDB的方法？
        if (!db.isTableExists(TABLENAME)){
            String createTableSql = "CREATE TABLE IF NOT EXISTS"+TABLENAME +"(id_DB integer)"+
                    "primary key AUTOINCREMENT,"+
                    User.NAME+"VARCHAR,"+
                    User.MOBILE+"VARCHAR,"+
                    User.QQ+"VARCHAR,"+
                    User.DANWEI+"VARCHAR,"+
                    User.ADDRESS+"VARCHAR)";
            db.createTable(createTableSql);
        }
    }
//增加数据
    //为什么都是用boolean类型返回的
    public boolean addData(User user){
        //创建ContentVaules对象用于保存数据
        //那么说来Content确实类似于内容物的意思？
        ContentValues values = new ContentValues();
        //赋值
        values.put(User.NAME,user.getName());
        values.put(User.MOBILE,user.getMobile());
        values.put(User.DANWEI,user.getDanwei());
        values.put(User.QQ,user.getQq());
        values.put(User.ADDRESS,user.getAddress());
        //保存数据
        return db.save(TABLENAME,values);
    }
}
