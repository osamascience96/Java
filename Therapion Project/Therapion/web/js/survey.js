var gender = undefined;
var age = 0;
var identity = undefined;
var country = undefined;
var language = undefined;
var communication_method = undefined;
var therapist_csv = undefined;

var viewCount = 0;
const viewList = ['survey1', 'survey2', 'survey3', 'survey4', 'survey5', 'survey6', 'survey7', 'survey8'];
var currentView = viewList[viewCount];

$(document).ready(function(){
    // get the country
    $.ajax({
        "url": "https://restcountries.com/v3.1/all",
        "method": "GET",
        "timeout": 0,
    }).done(function(response){
        const data = response;
        data.forEach(item => {
            const value = item['name'].common;
            $('#country_select').append(`<option value='${value}'>${value}</option>`)
        });
    });
    
});

// hide all elements
function hide_all_views(){
    viewList.forEach(item => {
       $(`#${item}`).css('display', 'none'); 
    });
}
// on click next
function on_next_click(){
    if(viewCount < (viewList.length - 1)){
        is_validated = checkValidity(currentView);
        if(is_validated === true){
            // hide the current view
            $(`#${currentView}`).css('display', 'none');
            viewCount +=1;

            // set the next view
            currentView = viewList[viewCount];

            // display the current view
            $(`#${currentView}`).css('display', 'block');
        }
    }
}
// on click previous
function on_previous_click(){
    if(viewCount > 0){
        // hide the current view
        $(`#${currentView}`).css('display', 'none');
        viewCount -=1;
        
        // set the previous view
        currentView = viewList[viewCount];
        
        // display the current view
        $(`#${currentView}`).css('display', 'block');
    }
}

function checkValidity(currentScren){
    var is_validated = false;
    
    switch (currentScren){
        case 'survey1':
            if(gender !== undefined){
                is_validated = true;
            }
            break;
        case 'survey2':
            var ageData = $('#age_option').val();
            if(ageData > 0){
                age = Number(ageData);
                is_validated = true;
            }
            break;
        case 'survey3':
            if(identity !== undefined){
                is_validated = true;
            }
            break;
        case 'survey4':
            if(country !== undefined){
                is_validated = true;
            }
            break;
        case 'survey5':
            if(language !== undefined){
                is_validated = true;
            }
            break;
        case 'survey6':
            if(communication_method !== undefined){
                is_validated = true;
            }
            break;
        case 'survey7':
            const male_therapist = $('#male_therapist').is(':checked') ? "Male Therapist" : "";
            const female_therapist = $('#female_therapist').is(':checked') ? "Female Therapist" : "";
            const other_therapist = $('#other_therapist').is(':checked') ? "Other Therapist" : "";
            
            if(male_therapist !== "" || female_therapist !== "" || other_therapist !== ""){
                therapist_csv = male_therapist + "," + female_therapist + "," + other_therapist;
            }
            
            is_validated = therapist_csv !== undefined ? true : false;
            break;
        case 'survey8':
            
            break;
        default:
            return false;
    }
    
    return is_validated;
}

function country_change_event(item){
    country = item.value;
}

function language_change_event(item){
    language = item.value;
}

function option_identity_survey(button){
    var identity_option_btn = document.getElementsByName(`${button.name}`);
    
    // set each button to default first
    identity_option_btn.forEach(btn => {
        btn.style.background = '#858CE4';
    });
    
    const btn_specs = $(`#${button.id}`);
    
    // change the css property
    btn_specs.css('background', 'rgba(133, 140, 228, 0.5)');
    // set the identity value
    identity = btn_specs.html();
}

function gender_selection_event(button){
    var gender_option_btn = document.getElementsByName(`${button.name}`);
    
    // set each button to default first
    gender_option_btn.forEach(btn => {
       btn.style.background = '#858CE4'; 
    });
    
    const btn_specs = $(`#${button.id}`);
    
    // change the css property
    btn_specs.css('background', 'rgba(133, 140, 228, 0.5)');
    // set the gender value
    gender = btn_specs.html();
}

function option_communicate_event(button){
    var option_communicate_btn = document.getElementsByName(`${button.name}`);
    
    // set each button to default first
    option_communicate_btn.forEach(btn => {
        btn.style.background = '#858CE4';
    });
    
    const btn_specs = $(`#${button.id}`);
    
    // change the css property
    btn_specs.css('background', 'rgba(133, 140, 228, 0.5)');
    communication_method = btn_specs.html();
}

$('#continue_last_btn').on('click', () => {
   // redirect the data to the registration page
   window.location.replace(`signup?gender=${gender}&age=${age}&identity=${identity}&country=${country}&language=${language}&communication_method=${communication_method}&therapist_csv=${therapist_csv}`); 
});