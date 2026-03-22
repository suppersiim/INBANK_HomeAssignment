public class LoanDecisionController {

    private final boolean hasDebt;
    private final double loanAmout;
    private final int loanPeriod;
    private final int creditModifier;
    final int minimumLoanAmout = 2000;
    final int maximumLoanAmout = 10000;

    public LoanDecisionController(boolean hasDebt, double loanAmout, int loanPeriod, int creditModifier) {
        this.hasDebt = hasDebt;
        this.loanAmout = loanAmout;
        this.loanPeriod = loanPeriod;
        this.creditModifier = creditModifier;
    }

    public boolean isHasDebt() {
        return hasDebt;
    }

    public double getLoanAmout() {
        return loanAmout;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public int getCreditModifier() {
        return creditModifier;
    }

    public boolean giveLoan(){
        if (isHasDebt()) return false;
        else return true;
    }

    public Integer calculateLoanAmout(){

        int maxLoanAmout = getCreditModifier() * getLoanPeriod();

        if (maxLoanAmout >= minimumLoanAmout){
            System.out.println("LOAN APPROVED");
            maxLoanAmout = Math.min(maxLoanAmout,maximumLoanAmout);
            return maxLoanAmout;
        }
        System.out.println("LOAN DISAPPROVED");
        return null;
    }


}
