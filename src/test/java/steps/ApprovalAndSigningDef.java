package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ApprovalAndSigning;

public class ApprovalAndSigningDef {

    private ApprovalAndSigning approvalAndSigning = new ApprovalAndSigning();

    @Then("Set complete condition {string}")
    public void setCompleteCondition(String arg0) {
        approvalAndSigning.completeCondition(arg0);
    }


    @Then("Add a checkout stage")
    public void addACheckoutStage() {
        approvalAndSigning.addStageChecking();
    }

    @Then("Crete design reviewer {string}")
    public void creteDesignReviewer(String arg0) {
        approvalAndSigning.creteDesignReviewer(arg0);
    }

    @Then("Add a approval stage and add approver {string}")
    public void addAApprovalStageAndApprover(String arg0) {
        approvalAndSigning.addAApprovalStageAndApprover(arg0);

    }

    @And("Add approver {string}")
    public void addApprover(String arg0) {
        approvalAndSigning.addApprover(arg0);
    }
}
