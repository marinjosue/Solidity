package ec.edu.espe.professor.model;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class Professor {
    private String name;
    private String subject;
    private String educational_level;
    private int experience;
    private String email;

    public Professor(String name, String subject, String educational_level, int experience, String email) {
        this.name = name;
        this.subject = subject;
        this.educational_level = educational_level;
        this.experience = experience;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEducational_level() {
        return educational_level;
    }

    public void setEducational_level(String educational_level) {
        this.educational_level = educational_level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
