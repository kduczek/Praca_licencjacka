Scenario: The scope of this test is to check if study plan is downloaded properly
Given a landing page of Faculty
When user clicks Rekrutacja tab
Then page is loaded
When user clicks Studia I stopnia in recruitment page
And user clicks for first study plan to download
Then file DLI_io_19_15maja2019.pdf is downloaded

Scenario: The scope of this test is to find teacher using Searching and get his email address
Given a landing page of Faculty
When user populate Search field with phrase Cybula and clicks People radio button
And clicks Search button
Then user gets searching results for given phrase Cybula
And user gets email of searched person

Scenario: The scope of this test is to check if schedule of academic year is downloaded properly
Given a landing page of Faculty
When user clicks Kalendarz from main menu
Then page is loaded
When user clicks for first schedule of academic year to download
Then file zarz.-nr-154-z-4.08.2020-r.pdf is downloaded

Scenario: The scope of this test is to check if user have access to recruitment website
Given a landing page of Faculty
When user clicks Rekrutacja tab
Then page is loaded
When user clicks Serwis Rekrutacyjny UŁ in recruitment page
Then user is on recruitment website

Scenario: The scope of this test is to spent some time on deans office site and then go to USOS
Given a landing page of Faculty
When user clicks Dziekanat from main menu
Then page is loaded
When user scrolls down page to bottom
And clicks USOS button
Then user is on USOS service website