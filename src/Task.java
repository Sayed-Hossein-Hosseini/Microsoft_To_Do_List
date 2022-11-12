import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task<T> {

    private String title;
    LinkedList<T> step;
    private int priority;

    private Date dueDate;
    private String note;
    private Date createdDate;

    SimpleDateFormat simpleDateFormat;

//==============cunstructor===============

    public Task(String title, int priority, String dueDate, String note) throws ParseException {
        this.simpleDateFormat = new SimpleDateFormat("yyyy M dd");
        this.title = title;
        this.step = new LinkedList<>();
        this.priority = priority;
        this.dueDate = simpleDateFormat.parse(dueDate);
        this.note = note;
        this.createdDate = new Date();
    }
//==============GET & SET===============

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LinkedList<T> getStep() {
        return step;
    }

    public void setStep(LinkedList<T> step) {
        this.step = step;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    //===============To String===============

    @Override
    public String toString() {
        return "Task" + '\n' +
                "title= " + title + '\n' +
                "priority= " + priority + '\n' +
                "note= " + note + '\n';
    }
}

