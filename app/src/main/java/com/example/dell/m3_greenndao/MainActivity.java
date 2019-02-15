package com.example.dell.m3_greenndao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dell.m3_greenndao.entity.UserEntity;
import com.example.dell.m3_greenndao.greendao.UserEntityDao;
import com.example.dell.m3_greenndao.utils.GreendaoUtils;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //添加
    public void add(View view)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("YYYYY");
        UserEntityDao userEntityDao = GreendaoUtils.getInstance().getDaoSession().getUserEntityDao();
        userEntityDao.insert(userEntity);
    }

    public void delete(View view)
    {
        //全部删除
        UserEntityDao entityDao = GreendaoUtils.getInstance().getDaoSession().getUserEntityDao();
        entityDao.deleteAll();

        //按条件删除
        List<UserEntity> list = entityDao.loadAll();
        for (UserEntity userEntity : list)
        {
            if (userEntity.getId()==1)
            {
                entityDao.delete(userEntity);
            }

        }

    }

    //查询
    public void queey(View view)
    {
        UserEntityDao entityDao = GreendaoUtils.getInstance().getDaoSession().getUserEntityDao();
        //查询所有
        List<UserEntity> userEntities = entityDao.loadAll();
        System.out.println("size:"+userEntities.size());
        for (UserEntity userEntity : userEntities)
        {
            System.out.println(userEntity.getName());
        }

        //条件查询
        List<UserEntity> userEntities1 = entityDao.queryRaw("where mallid = ? and name =? ", "2","张三丰");
        System.out.println("usersize:"+userEntities1.size());

        QueryBuilder<UserEntity> studentQueryBuilder = GreendaoUtils.getInstance().getDaoSession()
                .queryBuilder(UserEntity.class)
                .where(UserEntityDao.Properties.Id.eq("2"))
                .orderDesc(UserEntityDao.Properties.Id);
        List<UserEntity> list = studentQueryBuilder.list();
        System.out.println("querylistsize:"+list.size());
    }

    //修改
    public void updata(View view)
    {
        UserEntityDao entityDao = GreendaoUtils.getInstance().getDaoSession().getUserEntityDao();
        List<UserEntity> loadAll = entityDao.loadAll();
        for (UserEntity userEntity : loadAll) {
            if (userEntity.getId()==2)
            {
                userEntity.setName("LLLLLL");
                entityDao.update(userEntity);
            }
        }
    }
}
