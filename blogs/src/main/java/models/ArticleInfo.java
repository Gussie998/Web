package models;

import java.util.Date;

/**
 * User:DELL
 * Date:2021-04-04
 * Time:16:38
 */

//        id int primary key auto_increment,
//        createtime datetime default now(),
//        updatetime datetime default now(),
//        title varchar(100) not null,
//        content text not null,
//        rcount int default 1,
//        state int default 1,
//        uid int not null
public class ArticleInfo {
    private int id;
    private Date createtime;
    private Date updatetime;
    private String title;
    private String content;
    private int rcount;
    private int state;
    private  int uid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
