
import java.util.HashMap;

public class IssueDatabase {

    private HashMap<String,IssueRequest>  Issues = new HashMap<String,IssueRequest>();
    
    public void getIssueByID(String issueId) {
        
        IssueRequest iss = Issues.get(issueId);
        iss.showRequest();
    }

    public void showIssues() {
        for(IssueRequest i : Issues.values()){
                i.showRequest();
        }
    }

    public void newIssue() {
        IssueRequest i = new IssueRequest();
        i.createRequest();
        Issues.put(i.getId(), i);
    }
    
    public void fulfillIssue(String issueId) {
        try{
        IssueRequest i = Issues.get(issueId);
        i.updateStatus();
        }catch(NullPointerException e){
            System.out.println("Not Found");
        }

    }
    
    public void renewIssue(String issueId,int noOfDays) {
        try{
        IssueRequest i = Issues.get(issueId);
        i.renewal(noOfDays);
        }catch(NullPointerException e){
            System.out.println("Not Found");
        }

    }
}
