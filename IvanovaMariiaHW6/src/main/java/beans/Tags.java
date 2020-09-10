package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tags {


    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("id")
    @Expose
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                "Tags{" +
                        "name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        "}";
    }


    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Tags) == false) {
            return false;
        }
        Tags rhs = ((Tags) other);
        return ((((((((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id)))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))))))));
    }
}
