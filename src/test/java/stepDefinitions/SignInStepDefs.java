package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.SignInPage;

public class SignInStepDefs {
	SignInPage signIn = new SignInPage();

	@Given("^I am on (?:Reservation|reservation) landing page$")
	public void i_am_on_Reservation_landing_page() {
		signIn.openHomePage();
	}

	@When("^I login as a (\\w+) to the (\\w+) side$")
	public void i_login_as_a_student_to_the_light_side(String role, String side) throws Throwable {
		String username = signIn.getUserEmail(role, side);
		String password = signIn.getUserPassword(role, side);
		signIn.login(username, password);
	}

	@When("^I login as a student \"([^\"]*)\", \"([^\"]*)\" to the light side$")
	public void i_login_as_a_student_the_light_side(String role, String side) throws Throwable {
		String username = signIn.getUserEmail(role, side);
		String password = signIn.getUserPassword(role, side);
		signIn.login(username, password);
	}

	@When("^I login as a student with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_login_as_a_student_with_and(String email, String password) throws Throwable {
		signIn.login(email, password);
		//Thread.sleep(5000);
	}
}
