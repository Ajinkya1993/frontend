// Name: Namita Sibal Date: 12/14/16 Course Number: 08672
package edu.cmu.cs.webapp.hw4.databean;


import org.genericdao.PrimaryKey;


@PrimaryKey("favoriteid")
public class FavoriteBean {
	private int favoriteid;
    private int userid;
    private int clickcount;
    private String comment;
    private String url;
    private int    position;

    public int getFavoriteid() {
        return favoriteid;
    }
    public int getUserid() {
        return userid;
    }
    
    public String getUrl() {
        return url;
    }

    public String getComment() {
        return comment;
    }

    public int getClickcount() {
        return clickcount;
    }
    
    public void setUrl(String s) {
        url = s;
    }

    public void setComment(String s) {
        comment = s;
    }
    
    public void setUserid(int i) {
        userid = i;
    }

    public void setClickcount(int i) {
        clickcount = i;
    }
    
    public void setFavoriteid(int i) {
        favoriteid = i;
    }
    public int    getPosition()          { return position;     }
    public void   setPosition(int i)     { position = i;        }
   
}

