package cn.edu.gdmec.a07150817.mycontacts1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//声明UI控件
    //这跟java有点类型对不对
    private EditText nameEditText;
    private EditText mobileEditText;
    private EditText qqEditText;
    private EditText addressEditText;
    private EditText danweiEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        setTitle("添加联系人");
        //获取界面控件实例
        nameEditText = (EditText) findViewById(R.id.name);
        mobileEditText = (EditText) findViewById(R.id.mobile);
        qqEditText = (EditText) findViewById(R.id.qq);
        addressEditText = (EditText) findViewById(R.id.address);
        danweiEditText = (EditText) findViewById(R.id.danwei);
    }
    //创建选项菜单
    //还要创建选项菜单，拿来干嘛

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //不知道参数真就好像看天书
        menu.add(Menu.NONE,1,Menu.NONE,"保存");
        menu.add(Menu.NONE,2,Menu.NONE,"返回");
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            //原来上面那个1是用在这里的
            case 1:
                //又是这个蜜汁判断为空的方法
                //看起来各种不严谨
                if (!nameEditText.getText().toString().equals("")){
                    User user = new User();
                    //赋值
                    user.setName(nameEditText.getText().toString());
                    user.setMobile(mobileEditText.getText().toString());
                    user.setQq(qqEditText.getText().toString());
                    user.setAddress(addressEditText.getText().toString());
                    user.setDanwei(danweiEditText.getText().toString());
                    //创建数据表对象
                    ContactsTable ct = new ContactsTable(MainActivity.this);
                    //数据表增加数据
                    //调用上一个类的方法
                    if (ct.addData(user)){
                        //对这个奇怪的Toast的机制还不是很清楚啊
                        Toast.makeText(MainActivity.this,"添加成功",Toast.LENGTH_LONG).show();
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this,"添加失败",Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this,"请先输入数据",Toast.LENGTH_LONG).show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
