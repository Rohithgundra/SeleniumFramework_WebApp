package com.swc.pompages;

public interface ReleavantData {

	/* Login Page data parameters */
	
	 String expectedPageTitle = "Log in";
	 String expectedHeader = "UnizenSWM Sol.";
	 String expectedSubHeader = "Please Sign-in";
	 String expectedUsernamePlaceholder = "Username";
	 String expectedUsernameAttribute = "text";
	 String expectedPasswordAttribute = "password";
	 String expectedPasswordPlaceholder = "Password";
	 String expectedInvalidCredentialsErrorMsg = "Invalid Username/Password !";
	 String expectedInvalidUsernameErrorMsg = "Invalid Username/Password !";
	 String expectedInvalidPasswordErrorMsg = "Invalid Username/Password !";
	 String expectedBlankCredentialsErrorMsg = "Please enter Username!";
	 String expectedBlankPasswordErrorMsg = "Please enter Password!";
	 String expectedDashboardTitle = "Water";
	 String superadmin_uname = "uswm";
	 String superadmin_pword ="6";
	 String superadmin_emailid = "vikky3@unizentechnologies.com";
	 
	 /* Dashboard data parameters */
	 
	 String [] allLabelsPresentInWaterConsumption = {"Housing Type", "Apartments", "Blocks", "Water Meters", "From Date", "To Date", "Filter By", "Action"};
	 String expectedHeaderForWaterConsumption = "Water Consumption in Litres";
	 String expectedErrorMessageWhenFromDataIsMissing = "Choose FromDate";
	 String expectedErrorMessageWhenToDataIsMissing = "Choose ToDate";
	 String FromDate = "09/19/2018 6:00 AM";
	 String ToDate =  "09/19/2018 9:00 PM";
	 
	 
	 /* User Subscription data parameters */
	 
	 
	 String[] allLabelsPresentInUserSub = {"Housing Type", "Apartments", "Blocks", "Water Meters", "User Type", "Username", "Email ID", "Mobile Number", "Area", "Place", "Landmark"};
	 String expectedUserPageTitle = "Create User";
	 String expectedUserPageHeader = "Create User";
	 String expectedUserSubUsernamePlaceholder = "Enter Username";
	 String expectedUserSubEmailIDPlaceholder = "Enter Email ID";
	 String expectedUserSubMobileNumberPlaceholder = "Enter Mobile Number";
	 
	 String expectedErrorMessageWhenApartmentIsNotSelected = "Choose Apartment";
	 String expectedErrorMessageWhenBlockIsNotSelected = "Choose Block";
	 String expectedErrorMessageWhenWaterMeterIsNotSelected = "Choose Water Meter";
	 String expectedErrorMessageWhenUserTypeIsNotSelected = "Choose User Type";
	 String expectedErrorMessageWhenUsernameIsNotSet = "Invalid Username Format!! Spaces and Special characters are not allowed";
	 String expectedErrorMessageWhenEmailIDIsNotSet = "Invalid Email ID Format!";
	 String expectedErrorMessageWhenMobileNumberIsNotSet = "Please Specify Phone Number";
	 String expectedErrorMessageWhenMobileNumberIsNotValid = "Invalid Mobile Number !";
	 String expectedErrorMessageWhenMobileNumberIsIncomplete = "Invalid Mobile Number !";
	 String expectedErrorMessageWhenLocationIsNotSet = "Please Add Location";
	 String expectedErrorMessageWhenUsernameAlreadyExits = "Username already exists";
	 String expectedErrorMessageWhenEmailAlreadyExits = "Email already registered";
	 String expectedErrorMessageWhenWaterMeterIsAlreadyMapped = "Selected Water Meter is already mapped to an existing user!";
	 
	 String newUsername = "";
	 String newEmail = "";
	 String phoneNumber = "";
	 
	 String expectedSucessMessageWhenNewUserIsCreated = "User registered successfully.Please check your email notification for activation!";
}
