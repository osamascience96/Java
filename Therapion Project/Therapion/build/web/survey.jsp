<%@include file="includes/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/survey.css">
<title>Survey - Therapion</title>
</head>
  <body>
      <div id="survey_container" class="container">
          <h3>Welcome to the first step of knowing yourself more</h3>
          <p>This questionnaire asks several questions to help us understand how you're feeling and match you with the right therapist.</p>
          <div class="row">
              <div id="template" class="col-xs-12 col-sm-12 col-md-6">
                <div id="survey1">
                  <h3>What is your gender?</h3>
                  <div class="option_gender_survey">
                      <button id="male_gender_option" name="gender_option_btn" onclick="gender_selection_event(this)">Male</button>
                      <button id="female_gender_option" name="gender_option_btn" onclick="gender_selection_event(this)">Female</button>
                      <button id="other_gender_otpion" name="gender_option_btn" onclick="gender_selection_event(this)">Other</button>
                  </div>
                </div>
                <div id="survey2" style="display: none;">
                    <h3>How old are you?</h3>
                    <div class="option_age_survey">
                        <div class="form-group">
                            <label class="form-label">Enter your age</label>
                            <input type="number" id="age_option" class="form-control" />
                        </div>
                    </div>
                </div>
                <div id="survey3" style="display: none;">
                    <h3>How do you identify?</h3>
                    <div class="option_identity_survey">
                        <button id="straight_identity_option" name="identity_option_btn" onclick="option_identity_survey(this)">Straight</button>
                        <button id="gay_identity_option" name="identity_option_btn" onclick="option_identity_survey(this)">Gay</button>
                        <button id="lesbian_identity_option" name="identity_option_btn" onclick="option_identity_survey(this)">Lesbian</button>
                        <button id="other_identity_option" name="identity_option_btn" onclick="option_identity_survey(this)">Other</button>
                        <button id="pnts_identity_option" name="identity_option_btn" onclick="option_identity_survey(this)">Prefer not to say</button>
                    </div>
                </div>
                <div id="survey4" style="display: none;">
                    <h3>Which country are you in?</h3>
                    <div class="option_country_survey">
                        <div class="form-group">
                            <label class="form-label">Select your country</label>
                            <select id="country_select" class="form-select" aria-label="Country Select" onchange="country_change_event(this);"></select>
                        </div>
                    </div>
                </div>
                <div id="survey5" style="display: none;">
                    <h3>What is your preferred Language?</h3>
                    <div class="option_language_survey">
                        <div class="form-group">
                            <label class="form-label">Select your preferred language</label>
                            <select id="language_select" class="form-select" aria-label="Language Select" onchange="language_change_event(this);">
                                <option value="Chinese">Chinese</option>
                                <option value="Spanish">Spanish</option>
                                <option value="English">English</option>
                                <option value="Urdu">Urdu</option>
                                <option value="Hindi">Hindi</option>
                                <option value="Italian">Italian</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div id="survey6" style="display: none;">
                    <h3>How do you prefer to communicate with your therapist</h3>
                    <div class="option_communicatemethod_survey">
                      <button id="option_messagemethod_survey" name="option_communicatemethod_btn" onclick="option_communicate_event(this)">Mostly via messaging</button>
                      <button id="option_phonevideosessionmethod_survey" name="option_communicatemethod_btn" onclick="option_communicate_event(this)">Via phone or video sessions</button>
                      <button id="option_nomethod_survey" name="option_communicatemethod_btn" onclick="option_communicate_event(this)">Not sure yet(decide later)</button>
                    </div>
                </div>
                <div id="survey7" style="display: none;">
                    <h3>Specific preferences for your therapist</h3>
                    <div class="option_preferences_survey">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="male_therapist" />
                            <label class="form-check-label text-white" for="male_therapist">Male Therapist</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="female_therapist" />
                            <label class="form-check-label text-white" for="female_therapist">Female Therapist</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="other_therapist" />
                            <label class="form-check-label text-white" for="other_therapist">Older therapist (45+)</label>
                        </div>
                    </div>
                </div>
                <div id="survey8" style="display: none;">
                    <h3>You've completed the questionnaire!</h3>
                    <div class="last_step">
                        <p class="text-bold text-white">Now you're ready to make an account</p>
                        <button id="continue_last_btn" onclick="">Continue</button>
                    </div>
                </div>
              </div>
          </div>
            <div id="survey_btn_nav" class="row">
              <div class="col-xs-12 col-sm-12 col-md-6">
                  <div class="d-grid gap-2 p-2">
                      <button type="button" class="btn btn-sm btn-secondary float-start" onclick="on_previous_click()">Previous</button>
                  </div>
              </div>
              <div class="col-xs-12 col-sm-12 col-md-6">
                  <div class="d-grid gap-2 p-2">
                    <button type="button" class="btn btn-sm btn-primary float-end" onclick="on_next_click()">Next</button>
                  </div>
              </div>
          </div>
      </div>
      <script src="<%=request.getContextPath()%>/js/survey.js"></script>
<%@include file="includes/footer.jsp" %>