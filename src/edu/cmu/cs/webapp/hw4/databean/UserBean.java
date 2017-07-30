// Name: Namita Sibal Date: 12/14/16 Course Number: 08672
package edu.cmu.cs.webapp.hw4.databean;

import org.genericdao.PrimaryKey;

@PrimaryKey("userid")
public class UserBean {
	private int userid;
    private String password;
    private String emailaddress;
    private String firstname;
    private String lastname;
    
    public int getUserid() {
        return userid;
    }
    public void setUserid(int i) {
        userid = i;
    }

    public String getPassword()        { return password; }
    public String getEmailaddress()        { return emailaddress; }

    public void setPassword(String s)  {  password = s;    }
    public void setEmailaddress(String s)  { emailaddress = s;    }
    
    public String getFirstname()        { return firstname; }
    public String getLastname()        { return lastname; }

    public void setFirstname(String s)  {  firstname = s;    }
    public void setLastname(String s)  { lastname = s;    }
}

