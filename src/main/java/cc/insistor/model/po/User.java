package cc.insistor.model.po;

import javax.validation.constraints.NotNull;

/**
 * @author cc
 */
public class User {
    private int id;
    private String name;
    @NotNull(message = "密码不能为空！！！！")
    private String passWord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
