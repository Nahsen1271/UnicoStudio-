package com.unicoStudio.pages;

public class AllPages {

        public AllPages(){
        }


        private AboutPage aboutPage;
        private HomePage homePage;
        private CareersPage careersPage;
        private GamesPages gamesPages;
        private AgeOfBrainos ageOfBrainos;



        public AboutPage aboutPage(){
            if (aboutPage == null){
                aboutPage = new AboutPage();
            }
            return aboutPage;
        }

        public HomePage homePage(){
            if (homePage == null){
                homePage = new HomePage();
            }
            return homePage;
        }

        public CareersPage careersPage(){
            if (careersPage == null){
                careersPage = new CareersPage();
            }
            return careersPage;
        }

        public GamesPages gamesPages(){
            if (gamesPages == null){
                gamesPages = new GamesPages();
            }
            return gamesPages;
        }
        public AgeOfBrainos ageOfBrainos(){
            if (ageOfBrainos == null){
                ageOfBrainos = new AgeOfBrainos();
            }
            return ageOfBrainos;
        }


}
