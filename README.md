# webdog ‒ quality scanner for websites #

#### Usage ####
`NAME
        java -jar webdog-1.1-SNAPSHOT.jar - HTML sanity checker

SYNOPSIS
        java -jar webdog-1.1-SNAPSHOT.jar [OPTION]... [FOLDER]...

DESCRIPTION
        Checks HTML for sanity.

        -jo, --jsoup-only
            use only JSoup to scan  (https://jsoup.org)

        -so, --selenuim-only
            use only selenium to scan (https://www.selenium.dev)

        -wd=TYPE, --webdriver=TYPE
            use 'geckodriver' for Firefox, 'chromedriver' for Google Chrome and Chromium`