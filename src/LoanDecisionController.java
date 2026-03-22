public class LoanDecisionController {

    private final String personalCode;
    private final double loanAmount;
    private final int loanPeriod;
    private final int minimumLoanAmount = 2000;
    private final int maximumLoanAmount = 10000;
    private final int minimumLoanPeriod = 12;
    private final int maximumLoanPeriod = 60;

    public LoanDecisionController(String personalCode, double loanAmount, int loanPeriod) {
        this.personalCode = personalCode;
        this.loanAmount = loanAmount;
        this.loanPeriod = loanPeriod;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public int getMinimumLoanAmount() {
        return minimumLoanAmount;
    }

    public int getMaximumLoanAmount() {
        return maximumLoanAmount;
    }

    public int getMinimumLoanPeriod() {
        return minimumLoanPeriod;
    }

    public int getMaximumLoanPeriod() {
        return maximumLoanPeriod;
    }

    public Integer getCreditScore(){
        if (getPersonalCode().equals("49002010965")) return null;
        else if (getPersonalCode().equals("49002010976")) return 100;
        else if (getPersonalCode().equals("49002010987")) return 300;
        else if (getPersonalCode().equals("49002010998")) return 1000;
    }

    public boolean InputController(){

        if (getCreditScore() != null &&
            getLoanAmount() >= getMinimumLoanAmount() && getLoanAmount() <= getMaximumLoanAmount() &&
            getLoanPeriod() >= getMinimumLoanPeriod() && getMinimumLoanPeriod() <= getMaximumLoanPeriod()
            ){
            return true;
        }
        return false;

    }

}
