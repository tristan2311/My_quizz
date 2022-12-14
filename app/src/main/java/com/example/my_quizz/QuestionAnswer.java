package com.example.my_quizz;

import android.widget.Button;

import java.util.Map;
import java.util.HashMap;

public class QuestionAnswer {

    //Création des Hashmap qui stocke comme valeur les questions et les réponses et la bonne réponse et la clé est un entier
    //ce qui permet d'accéder au questions et réponses juste grâce à un entier
    public static Map<Integer, String[][]> EuropeAnswer = new HashMap<Integer, String[][]>();
    public static Map<Integer, String[][]> AmeriqueAnswer = new HashMap<Integer, String[][]>();
    public static Map<Integer, String[][]> AfriqueAnswer = new HashMap<Integer, String[][]>();
    public static Map<Integer, String[][]> AllAnswer = new HashMap<Integer, String[][]>();

    //Pays d'Europe
    public static void createEuropeAnswer(){
        EuropeAnswer.put(1 , new String[][]{{"Quelle est la capitale de la France?"},              {"Berlin","Paris","Madrid","Londres"},            {"Paris"}});
        EuropeAnswer.put(2 , new String[][]{{"Quelle est la capitale de l'Espagne?"},              {"Barcelone","Paris","Madrid","Lisbonne"},        {"Madrid"}});
        EuropeAnswer.put(3 , new String[][]{{"Quelle est la capitale de la Belgique?(le Seum au foot)"},            {"Belgrade","Bruxelles","Bruges","Amsterdam"},    {"Bruxelles"}});
        EuropeAnswer.put(4 , new String[][]{{"Quelle est la capitale de l'Allemagne?"},            {"Berlin","Munich","Prague","Dublin"},            {"Berlin"}});
        EuropeAnswer.put(5 , new String[][]{{"Quelle est la capitale de la Suisse?"},              {"Berne","Bale","Zurich","Genève"},               {"Berne"}});
        EuropeAnswer.put(6 , new String[][]{{"Quelle est la capitale de la l'Italie?"},            {"Rome","Madrid","Milan","Monaco"},               {"Rome"}});
        EuropeAnswer.put(7 , new String[][]{{"Quelle est la capitale du Portugal?"},               {"Lisbonne","Porto","Madrid","Amsterdam"},        {"Lisbonne"}});
        EuropeAnswer.put(8 , new String[][]{{"Quelle est la capitale des Pays-Bas?"},              {"Amsterdam","Rotterdam","Madrid","Mexico"},      {"Amsterdam"}});
        EuropeAnswer.put(9 , new String[][]{{"Quelle est la capitale de l'Autriche?"},             {"Munich","Prague","Vienne","Zagreb"},            {"Vienne"}});
        EuropeAnswer.put(10 , new String[][]{{"Quelle est la capitale de la Slovénie?"},           {"Ljubljana","Zagreb","Sarajevo","Budapest"},     {"Ljubljana"}});
        EuropeAnswer.put(11 , new String[][]{{"Quelle est la capitale de la République Tchèque?"}, {"Prague","Budapest","Bucarest","Vienne"},        {"Prague"}});
        EuropeAnswer.put(12 , new String[][]{{"Quelle est la capitale de la Pologne?"},            {"Vienne","Varsovie","Madrid","Mexico"},          {"Varsovie"}});
        EuropeAnswer.put(13 , new String[][]{{"Quelle est la capitale de la Hongrie?"},            {"Budapest","Bucarest","Kiev","Sofia"},           {"Budapest"}});
        EuropeAnswer.put(14 , new String[][]{{"Quelle est la capitale de la Bosnie Herzégovine?"}, {"Sarajevo","Zagreb","Sofia","Tirana"},           {"Sarajevo"}});
        EuropeAnswer.put(15 , new String[][]{{"Quelle est la capitale de la Slovaquie?"},          {"Bratislava","Zagreb","Ljubljana","Prague"},     {"Bratislava"}});
        EuropeAnswer.put(16 , new String[][]{{"Quelle est la capitale de la Roumanie?"},           {"Bucarest","Budapest","Sofia","Belgrade"},       {"Bucarest"}});
        EuropeAnswer.put(17 , new String[][]{{"Quelle est la capitale de la Moldavie?"},           {"Chisinau","Skopje","Belgrade","Prague"},        {"Chisinau"}});
        EuropeAnswer.put(18 , new String[][]{{"Quelle est la capitale de l'Ukraine?"},             {"Moscou","Kiev","Varsovie","Tbilissi"},          {"Kiev"}});
        EuropeAnswer.put(19 , new String[][]{{"Quelle est la capitale de la Lituanie?"},           {"Moscou","Kiev","Vilnius","Riga"},               {"Vilnius"}});
        EuropeAnswer.put(20 , new String[][]{{"Quelle est la capitale de la Lettonie?"},           {"Ljubljana","Tallinn","Vilnius","Riga"},         {"Riga"}});
        EuropeAnswer.put(21 , new String[][]{{"Quelle est la capitale de l'Estonie?"},             {"Ljubljana","Tallinn","Riga","Vilnius"},         {"Tallinn"}});
        EuropeAnswer.put(22 , new String[][]{{"Quelle est la capitale de la Bulgarie?"},           {"Sofia","Belgrade","Prague","Istanbul"},         {"Sofia"}});
        EuropeAnswer.put(23 , new String[][]{{"Quelle est la capitale de la Serbie?"},             {"Bratislava","Tirana","Belgrade","Zagreb"},      {"Belgrade"}});
        EuropeAnswer.put(24 , new String[][]{{"Quelle est la capitale de la Grèce?"},              {"Nicosi","Istanbul","Madrid","Athènes"},         {"Athènes"}});
        EuropeAnswer.put(25 , new String[][]{{"Quelle est la capitale de l'Albanie?"},             {"Belgrade","Riga","Tirana","Tallin"},            {"Tirana"}});
        EuropeAnswer.put(26 , new String[][]{{"Quelle est la capitale du Luxembourg?"},            {"Berlin","Amsterdam","Berne","Luxembourg"},      {"Luxembourg"}});
        EuropeAnswer.put(27 , new String[][]{{"Quelle est la capitale du Danemark?"},              {"Copenhague","Oslo","Stockholm","Helsinki"},     {"Copenhague"}});
        EuropeAnswer.put(28 , new String[][]{{"Quelle est la capitale de la Norvège?"},            {"Copenhague","Oslo","Stockholm","Helsinki"},     {"Oslo"}});
        EuropeAnswer.put(29 , new String[][]{{"Quelle est la capitale de la Suède?"},              {"Copenhague","Oslo","Stockholm","Helsinki"},     {"Stockholm"}});
        EuropeAnswer.put(30 , new String[][]{{"Quelle est la capitale de la Finlande?"},           {"Copenhague","Oslo","Stockholm","Helsinki"},     {"Helsinki"}});
        EuropeAnswer.put(31 , new String[][]{{"Quelle est la capitale de l'Islande?"},             {"Copenhague","Oslo","Reykjavik","Helsinki"},     {"Reykjavik"}});
        EuropeAnswer.put(32 , new String[][]{{"Quelle est la capitale de la Biélorussie?"},        {"Varsovie","Kiev","Moscou","Minsk"},             {"Minsk"}});
        EuropeAnswer.put(33 , new String[][]{{"Quelle est la capitale de Chypre?"},                {"Bratislava","Nicosie","La Valette","Prague"},   {"Nicosie"}});
        EuropeAnswer.put(34 , new String[][]{{"Quelle est la capitale de Malte?"},                 {"Bratislava","La Valette","Nicosi","Prague"},    {"La Valette"}});
        EuropeAnswer.put(35 , new String[][]{{"Quelle est la capitale de la Turquie?"},            {"Istanbul","Athènes","Ankara","Sofia"},          {"Ankara"}});
        EuropeAnswer.put(36 , new String[][]{{"Quelle est la capitale de la Géorgie?"},            {"Prague","Ljubljana","Riga","Tbilissi"},         {"Tbilissi"}});
        EuropeAnswer.put(37 , new String[][]{{"Quelle est la capitale de la Russie?"},             {"Moscou","Minsk","Saint-Pétersbourg","Kiev"},    {"Moscou"}});
        EuropeAnswer.put(38 , new String[][]{{"Quelle est la capitale de la Macédoine du Nord?"},  {"Oslo","Skopje","Tirana","Sofia"},               {"Skopje"}});
        EuropeAnswer.put(39 , new String[][]{{"Quelle est la capitale du Monténégro?"},            {"Kiev","Stockholm","Riga","Podgorica"},          {"Podgorica"}});
        EuropeAnswer.put(40 , new String[][]{{"Quelle est la capitale du Royaume-Uni?"},           {"Glasgow","Dublin","Londres","Liverpool"},       {"Londres"}});
        EuropeAnswer.put(41 , new String[][]{{"Quelle est la capitale de l'Irlande?"},             {"Berlin","Dublin","Londres","Glasgow"},          {"Dublin"}});
        EuropeAnswer.put(42 , new String[][]{{"Quelle est la capitale de la Croatie"},             {"Bratislava","Tirana","Belgrade","Zagreb"},      {"Zagreb"}});
    }

    //Pays d'Amérique
    public static void createAmeriqueAnswer(){
        AmeriqueAnswer.put(1 , new String[][]{{"Quelle est la capitale de l'Argentine?"},               {"Buenos Aires","Córdoba","Santiago","Rosario"},         {"Buenos Aires"}});
        AmeriqueAnswer.put(2 , new String[][]{{"Quelle est la capitale des îles Bahamas?"},             {"Nassau","Freeport","La Havane","Miami"},                 {"Nassau"}});
        AmeriqueAnswer.put(3 , new String[][]{{"Quelle est la capitale de Belize?"},                    {"Belmopan","Belizz City","San Pedro","Guatemala"},        {"Belmopan"}});
        AmeriqueAnswer.put(4 , new String[][]{{"Quelle est la capitale de la Bolivie?"},                {"La Paz","Sucre","Santa Cruz de la Sierra","Santiago"},   {"La Paz"}});
        AmeriqueAnswer.put(5 , new String[][]{{"Quelle est la capitale du Canada?"},                    {"Ottawa","Montréale","Québéc","Torronto"},                {"Ottawa"}});
        AmeriqueAnswer.put(6 , new String[][]{{"Quelle est la capitale du Brésil?"},                    {"Brésilia","Rio de Janeiro","Sao Paulo","Buenos Aires"},  {"Brésilia"}});
        AmeriqueAnswer.put(7 , new String[][]{{"Quelle est la capitale du Chili?"},                     {"Santiago","Arica","Lima","La Paz"},                      {"Santiago"}});
        AmeriqueAnswer.put(8 , new String[][]{{"Quelle est la capitale de la Colombie?"},               {"Medelin","Cali","Bogota","Caracas"},                     {"Bogota"}});
        AmeriqueAnswer.put(9 , new String[][]{{"Quelle est la capitale du Costa Rica?"},                {"San José","Managua","Panama","Tegucigalpa"},             {"San José"}});
        AmeriqueAnswer.put(10 , new String[][]{{"Quelle est la capitale de la République Dominicaine?"},{"Saint-Domingue","Punta Cana","Port-au_price","Santiago"},{"Saint-Domingue"}});
        AmeriqueAnswer.put(11 , new String[][]{{"Quelle est la capitale de l'Equateur'?"},              {"Quito","Guayaquil","Lima","Caracas"},                    {"Quito"}});
        AmeriqueAnswer.put(12 , new String[][]{{"Quelle est la capitale des Etat-Unis?"},               {"Washigton","New York","Chicago","Los angeles"},          {"Washigton"}});
        AmeriqueAnswer.put(13 , new String[][]{{"Quelle est la capitale du Guatemala?"},                {"Guatemala","Antigua Guatemala","Mérida","La Havane"},    {"Guatemala"}});
        AmeriqueAnswer.put(14 , new String[][]{{"Quelle est la capitale de Guyana?"},                   {"Georgetown","Paramaribo","Kourou","Caracas"},            {"Georgetown"}});
        AmeriqueAnswer.put(15 , new String[][]{{"Quelle est la capitale de Haïti?"},                    {"Port-au-Prince","Cap-Haïtien","Carrefour","La Havane"},  {"Port-au-Prince"}});
        AmeriqueAnswer.put(16 , new String[][]{{"Quelle est la capitale du Honduras?"},                 {"Tegucigalpa","San Pedro Sula","Managua","Belmopan"},     {"Tegucigalpa"}});
        AmeriqueAnswer.put(17 , new String[][]{{"Quelle est la capitale de la Jamaïque?"},              {"Kingston","Montego Bay","La Havane","Saint-Domingue"},   {"Kingston"}});
        AmeriqueAnswer.put(18 , new String[][]{{"Quelle est la capitale du Mexique?"},                  {"Mexico","Mérida","Guadalaja","San Salvador"},            {"Mexico"}});
        AmeriqueAnswer.put(19 , new String[][]{{"Quelle est la capitale du Nicaragua?"},                {"Managua","San José","Caracas","Santiago"},               {"Managua"}});
        AmeriqueAnswer.put(20 , new String[][]{{"Quelle est la capitale du Panama?"},                   {"Panama","Guatemala","Managua","Caracas"},                {"Panama"}});
        AmeriqueAnswer.put(21 , new String[][]{{"Quelle est la capitale du Paraguay?"},                 {"Asuncion","Montevideo","La Paz","Santiago"},             {"Asuncion"}});
        AmeriqueAnswer.put(22 , new String[][]{{"Quelle est la capitale du Pérou?"},                    {"Lima","Santiago","Quito","La Paz"},                      {"Lima"}});
        AmeriqueAnswer.put(23 , new String[][]{{"Quelle est la capitale du Salvador?"},                 {"San Salvador","San Antonio","San Andreas","Santiago"},   {"San Salvador"}});
        AmeriqueAnswer.put(24 , new String[][]{{"Quelle est la capitale du Suriname?"},                 {"Paramaribo","Kourou","Quito","Caracas"},                 {"Paramaribo"}});
        AmeriqueAnswer.put(25 , new String[][]{{"Quelle est la capitale de l'Uruguay?"},                {"Montevideo","Buenos Aires","Tirana","Santiago"},         {"Montevideo"}});
        AmeriqueAnswer.put(26 , new String[][]{{"Quelle est la capitale du Vénézuéla?"},                {"Caracas","Santiago","Bogota","Curaçao"},                 {"Caracas"}});
    }

    //Pays d'Afrique
    public static void createAfriqueAnswer(){
        AfriqueAnswer.put(1 , new String[][]{{"Quelle est la capitale de l'Afrique du sud?"},                   {"Johannesburg","Windhoek","Gaborone","Maputo"},           {"Johannesburg"}});
        AfriqueAnswer.put(2 , new String[][]{{"Quelle est la capitale de l'Algérie?"},                          {"Alger","Oran","Tanger","Rabat"},                         {"Alger"}});
        AfriqueAnswer.put(3 , new String[][]{{"Quelle est la capitale de l'Angola?"},                           {"Luanda","Benguela","Kinshasa","Windhoek"},               {"Luanda"}});
        AfriqueAnswer.put(4 , new String[][]{{"Quelle est la capitale du Bénin?"},                              {"Porto-Novo","Lomé","Lagos","Bamako"},                    {"Porto-Novo"}});
        AfriqueAnswer.put(5 , new String[][]{{"Quelle est la capitale du Botswana?"},                           {"Gaborone","Harare","Lusaka","Windhoek"},                 {"Gaborone"}});
        AfriqueAnswer.put(6 , new String[][]{{"Quelle est la capitale du Burkina Faso?"},                       {"Ouagadougou","Lomé","Accra","Yamoussoukro"},             {"Ouagadougou"}});
        AfriqueAnswer.put(7 , new String[][]{{"Quelle est la capitale du Burundi?"},                            {"Gitega","Lusaka","Kinshasa","Kampala"},                  {"Gitega"}});
        AfriqueAnswer.put(8 , new String[][]{{"Quelle est la capitale du Cameroun?"},                           {"Yaoundé","Libreville","Abuja","Abidjan"},                {"Yaoundé"}});
        AfriqueAnswer.put(9 , new String[][]{{"Quelle est la capitale du Cap-Vert?"},                           {"Praia","Dakar","Bissau","Kinshasa"},                     {"Praia"}});
        AfriqueAnswer.put(10 , new String[][]{{"Quelle est la capitale de la République Centrafricaine?"},      {"Bangui","Djouba","Kampala","Lusaka"},                    {"Bangui"}});
        AfriqueAnswer.put(11 , new String[][]{{"Quelle est la capitale des Comores?"},                          {"Moroni","Tananarive","Maputo","Nairobi"},                {"Moroni"}});
        AfriqueAnswer.put(12 , new String[][]{{"Quelle est la capitale de la République du Congo?"},            {"Brazzaville","Kinshasa","Bangui","Nairobi"},             {"Brazzaville"}});
        AfriqueAnswer.put(13 , new String[][]{{"Quelle est la capitale de la Républiquedémocratique du Congo?"},{"Kinshasa","Moroni","Bangui","Nairobi"},                  {"Kinshasa"}});
        AfriqueAnswer.put(14 , new String[][]{{"Quelle est la capitale de la Côte d'Ivoire?"},                  {"Abidjan","Yamoussoukro","Accra","Kissidougou"},          {"Yamoussoukro"}});
        AfriqueAnswer.put(15 , new String[][]{{"Quelle est la capitale de Djibouti?"},                          {"Djibouti","Asmara","Addis-Abeba","Khartoum"},            {"Djibouti"}});
        AfriqueAnswer.put(16 , new String[][]{{"Quelle est la capitale de l'Egypte?"},                          {"Le Caire","Alexandrie","Khartoum","Tripoli"},            {"Le Caire"}});
        AfriqueAnswer.put(17 , new String[][]{{"Quelle est la capitale de l'Erythrée?"},                        {"Asmara","Djibouti","Addis-Abeba","Khartoum"},            {"Asmara"}});
        AfriqueAnswer.put(18 , new String[][]{{"Quelle est la capitale de l'Eswatini?"},                        {"Mbabane","Maputo","Pretoria","Gaborone"},                {"Mbabane"}});
        AfriqueAnswer.put(19 , new String[][]{{"Quelle est la capitale de l'Ethiopie?"},                        {"Addis-Abeba","Mogadiscio","Djibouti","Khartoum"},        {"Addis-Abeba"}});
        AfriqueAnswer.put(20 , new String[][]{{"Quelle est la capitale du Gabon?"},                             {"Libreville","Luanda","Yaoundé","Sao Tomé"},              {"Libreville"}});
        AfriqueAnswer.put(21 , new String[][]{{"Quelle est la capitale de la Gambie?"},                         {"Banjul","Dakar","Bissau","Monrovia"},                    {"Banjul"}});
        AfriqueAnswer.put(22 , new String[][]{{"Quelle est la capitale du Ghana?"},                             {"Accra","Lomé","Dakar","Abuja"},                          {"Accra"}});
        AfriqueAnswer.put(23 , new String[][]{{"Quelle est la capitale de la Guinée?"},                         {"Kolda","Malabo","Conakry","Bissau"},                     {"Kolda"}});
        AfriqueAnswer.put(53, new String[][]{{"Quelle est la capitale de la Guinée-Bissau?"},                  {"Bissau","Malabo","Kolda","Conakry"},                     {"Bissau"}});
        AfriqueAnswer.put(24 , new String[][]{{"Quelle est la capitale de la Guinée-Equatoriale?"},             {"Malabo","Bissau","Kolda","Conakry"},                     {"Malabo"}});
        AfriqueAnswer.put(25 , new String[][]{{"Quelle est la capitale du Kenya?"},                             {"Nairobi","Kampala","Djouba","Magadiscio"},               {"Nairobi"}});
        AfriqueAnswer.put(26 , new String[][]{{"Quelle est la capitale du Lesotho?"},                           {"Maseru","Mbabane","Gaborone","Windhoek"},                {"Maseru"}});
        AfriqueAnswer.put(27 , new String[][]{{"Quelle est la capitale du Libéria"},                            {"Monrovia","Freetown","Yamoussoukro","Bamako"},           {"Monrovia"}});
        AfriqueAnswer.put(28 , new String[][]{{"Quelle est la capitale de la Libye?"},                          {"Tripoli","Tunis","Beyrouth","Abuja"},                    {"Tripoli"}});
        AfriqueAnswer.put(29 , new String[][]{{"Quelle est la capitale de Madagascar?"},                        {"Tananarive","Belizz City","San Pedro","Guatemala"},      {"Moroni"}});
        AfriqueAnswer.put(30 , new String[][]{{"Quelle est la capitale du Malawi?"},                            {"Lilongwe","Bamako","Lusaka","Harare"},                   {"Lilongwe"}});
        AfriqueAnswer.put(31 , new String[][]{{"Quelle est la capitale du Mali?"},                              {"Bamako","Lilongwe","Dakar","Yamassoukra"},               {"Bamako"}});
        AfriqueAnswer.put(32 , new String[][]{{"Quelle est la capitale du Maroc?"},                             {"Rabat","Casablanca","Tanger","Alger"},                   {"Rabat"}});
        AfriqueAnswer.put(33 , new String[][]{{"Quelle est la capitale de l'île Maurice?"},                     {"Port Louis","Saint-Denis","Tananarive","Port-au-Prince"},{"Port Louis"}});
        AfriqueAnswer.put(34 , new String[][]{{"Quelle est la capitale de la Mauritanie?"},                     {"Nouakchott","Banjul","Bissau","Conakry"},                {"Nouakchott"}});
        AfriqueAnswer.put(35 , new String[][]{{"Quelle est la capitale du Mozambique?"},                        {"Maputo","Mbabane","Gaborone","Harare"},                  {"Maputo"}});
        AfriqueAnswer.put(36 , new String[][]{{"Quelle est la capitale de la Namibie?"},                        {"Windhoek","Luanda","Gaborone","Lusaka"},                 {"Windhoek"}});
        AfriqueAnswer.put(37 , new String[][]{{"Quelle est la capitale du Niger?"},                             {"Niamey","Lagos","Abuja","Bamako"},                       {"Niamey"}});
        AfriqueAnswer.put(38 , new String[][]{{"Quelle est la capitale du Nigeria?"},                           {"Abuja","Lagos","Niamey","Yaoundé"},                      {"Abuja"}});
        AfriqueAnswer.put(39 , new String[][]{{"Quelle est la capitale de l'Ouganda?"},                         {"Kampala","Nairobie","Djouba","Harare"},                  {"Kampala"}});
        AfriqueAnswer.put(40 , new String[][]{{"Quelle est la capitale du Rwanda?"},                            {"Kigali","Bujumbura","Gitega","Kampala"},                 {"Kigali"}});
        AfriqueAnswer.put(41 , new String[][]{{"Quelle est la capitale du Sénégal?"},                           {"Dakar","Bamako","Yamassouko","Conakry"},                 {"Dakar"}});
        AfriqueAnswer.put(43 , new String[][]{{"Quelle est la capitale de Sierra Leone?"},                      {"Freetown","Conakry","Monrovia","Yamassouko"},            {"Freetown"}});
        AfriqueAnswer.put(44 , new String[][]{{"Quelle est la capitale de la Somalie?"},                        {"Mogadiscio","Djibouti","Addis-Abeba","Nairobi"},         {"Mogadiscio"}});
        AfriqueAnswer.put(45 , new String[][]{{"Quelle est la capitale du Soudan?"},                            {"Khartoum","Asmara","Addis-Abeba","Djouba"},              {"Khartoum"}});
        AfriqueAnswer.put(46 , new String[][]{{"Quelle est la capitale du Soudan du Sud?"},                     {"Djouba","Khartoum","Asmara","Addis-Abeba"},              {"Djouba"}});
        AfriqueAnswer.put(47 , new String[][]{{"Quelle est la capitale de la Tanzanie?"},                       {"Dodoma","Lilongwe","Kigali","Gitega"},                   {"Dodoma"}});
        AfriqueAnswer.put(48 , new String[][]{{"Quelle est la capitale du Tchad?"},                             {"N'Djamena","Niamey","Yaoundé","Bangui"},                 {"N'Djamena"}});
        AfriqueAnswer.put(49 , new String[][]{{"Quelle est la capitale du Togo?"},                              {"Lomé","Accra","Lagos","Porto-Novo"},                     {"Lomé"}});
        AfriqueAnswer.put(50 , new String[][]{{"Quelle est la capitale de la Tunisie?"},                        {"Tunis","Alger","Rabat","Tripoli"},                       {"Tunis"}});
        AfriqueAnswer.put(51 , new String[][]{{"Quelle est la capitale de la Zambie?"},                         {"Lusaka","Harare","Lilongwe","Baborone"},                 {"Lusaka"}});
        AfriqueAnswer.put(52 , new String[][]{{"Quelle est la capitale du Zimbabwe?"},                          {"Harare","Lusaka","Lilongwe","Maputo"},                   {"Harare"}});
    }

    //Création d'une Hashmap contenant les trois Hashmap précédente mais en modifiant les clé pour ne pas avoir de doublons
    public static void createAllAnswer(){
        int i = 0;
        AllAnswer.putAll(EuropeAnswer);
        i = EuropeAnswer.size()+1;
        for (String[][] Answer : AmeriqueAnswer.values()){
            AllAnswer.put(i,Answer);
            i += 1;
        }
        for (String[][] Answer2 : AfriqueAnswer.values()){
            AllAnswer.put(i,Answer2);
            i += 1;
        }
    }

    //Permet d'executer les 4 fonctions précédente (cette fonction est appelé dans MainActivity
    public static void createHashmap(){
        createEuropeAnswer();
        createAmeriqueAnswer();
        createAfriqueAnswer();
        createAllAnswer();
    }
}