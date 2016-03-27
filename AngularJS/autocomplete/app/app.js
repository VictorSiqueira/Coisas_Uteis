//Define an angular module for our app
var app = angular.module('myApp', ['ui.bootstrap']);

app.controller('autocompleteController', function ($scope, $http) {
  
    $scope.countries = [
    {
        "country": "Abkhazia",
        "capital": "Sokhumi"
    }, {
        "country": "Afghanistan",
        "capital": "Kabul"
    }, {
        "country": "Aland",
        "capital": "Mariehamn"
    }, {
        "country": "Albania",
        "capital": "Tirana"
    }, {
        "country": "Algeria",
        "capital": "Algiers"
    }, {
        "country": "American Samoa",
        "capital": "Pago Pago"
    }, {
        "country": "Andorra",
        "capital": "Andorra la Vella"
    }, {
        "country": "Angola",
        "capital": "Luanda"
    }, {
        "country": "Anguilla",
        "capital": "The Valley"
    }, {
        "country": "Antigua and Barbuda",
        "capital": "Saint John's"
    }, {
        "country": "Argentina",
        "capital": "Buenos Aires"
    }, {
        "country": "Armenia",
        "capital": "Yerevan"
    }, {
        "country": "Aruba",
        "capital": "Oranjestad"
    }, {
        "country": "Ascension",
        "capital": "Georgetown"
    }, {
        "country": "Australia",
        "capital": "Canberra"
    }, {
        "country": "Austria",
        "capital": "Vienna"
    }, {
        "country": "Azerbaijan",
        "capital": "Baku"
    }, {
        "country": "Bahamas, The",
        "capital": "Nassau"
    }, {
        "country": "Bahrain",
        "capital": "Manama"
    }, {
        "country": "Bangladesh",
        "capital": "Dhaka"
    }, {
        "country": "Barbados",
        "capital": "Bridgetown"
    }, {
        "country": "Belarus",
        "capital": "Minsk"
    }, {
        "country": "Belgium",
        "capital": "Brussels"
    }, {
        "country": "Belize",
        "capital": "Belmopan"
    }, {
        "country": "Benin",
        "capital": "Porto-Novo"
    }, {
        "country": "Bermuda",
        "capital": "Hamilton"
    }, {
        "country": "Bhutan",
        "capital": "Thimphu"
    }, {
        "country": "Bolivia",
        "capital": "La Paz (administrative/legislative) and Sucre (judical)"
    }, {
        "country": "Bosnia and Herzegovina",
        "capital": "Sarajevo"
    }, {
        "country": "Botswana",
        "capital": "Gaborone"
    }, {
        "country": "Brazil",
        "capital": "Brasilia"
    }, {
        "country": "British Sovereign Base Areas",
        "capital": "Episkopi"
    }, {
        "country": "British Virgin Islands",
        "capital": "Road Town"
    }, {
        "country": "Brunei",
        "capital": "Bandar Seri Begawan"
    }, {
        "country": "Bulgaria",
        "capital": "Sofia"
    }, {
        "country": "Burkina Faso",
        "capital": "Ouagadougou"
    }, {
        "country": "Burundi",
        "capital": "Bujumbura"
    }, {
        "country": "Cambodia",
        "capital": "Phnom Penh"
    }, {
        "country": "Cameroon",
        "capital": "Yaounde"
    }, {
        "country": "Canada",
        "capital": "Ottawa"
    }, {
        "country": "Cape Verde",
        "capital": "Praia"
    }, {
        "country": "Cayman Islands",
        "capital": "George Town"
    }, {
        "country": "Central African Republic",
        "capital": "Bangui"
    }, {
        "country": "Chad",
        "capital": "N'Djamena"
    }, {
        "country": "Chile",
        "capital": "Santiago (administrative/judical) and Valparaiso (legislative)"
    }, {
        "country": "China, People's Republic of",
        "capital": "Beijing"
    }, {
        "country": "China, Republic of (Taiwan)",
        "capital": "Taipei"
    }, {
        "country": "Christmas Island",
        "capital": "The Settlement (Flying Fish Cove)"
    }, {
        "country": "Cocos (Keeling) Islands",
        "capital": "West Island"
    }, {
        "country": "Colombia",
        "capital": "Bogota"
    }, {
        "country": "Comoros",
        "capital": "Moroni"
    }, {
        "country": "Congo, Democratic Republic of the (Congo ? Kinshasa)",
        "capital": "Kinshasa"
    }, {
        "country": "Congo, Republic of the (Congo ? Brazzaville)",
        "capital": "Brazzaville"
    }, {
        "country": "Cook Islands",
        "capital": "Avarua"
    }, {
        "country": "Costa Rica",
        "capital": "San Jose"
    }, {
        "country": "Cote d'Ivoire (Ivory Coast)",
        "capital": "Yamoussoukro"
    }, {
        "country": "Croatia",
        "capital": "Zagreb"
    }, {
        "country": "Cuba",
        "capital": "Havana"
    }, {
        "country": "Cyprus",
        "capital": "Nicosia"
    }, {
        "country": "Czech Republic",
        "capital": "Prague"
    }, {
        "country": "Denmark",
        "capital": "Copenhagen"
    }, {
        "country": "Djibouti",
        "capital": "Djibouti"
    }, {
        "country": "Dominica",
        "capital": "Roseau"
    }, {
        "country": "Dominican Republic",
        "capital": "Santo Domingo"
    }, {
        "country": "Ecuador",
        "capital": "Quito"
    }, {
        "country": "Egypt",
        "capital": "Cairo"
    }, {
        "country": "El Salvador",
        "capital": "San Salvador"
    }, {
        "country": "Equatorial Guinea",
        "capital": "Malabo"
    }, {
        "country": "Eritrea",
        "capital": "Asmara"
    }, {
        "country": "Estonia",
        "capital": "Tallinn"
    }, {
        "country": "Ethiopia",
        "capital": "Addis Ababa"
    }, {
        "country": "Falkland Islands (Islas Malvinas)",
        "capital": "Stanley"
    }, {
        "country": "Faroe Islands",
        "capital": "Torshavn"
    }, {
        "country": "Fiji",
        "capital": "Suva"
    }, {
        "country": "Finland",
        "capital": "Helsinki"
    }, {
        "country": "France",
        "capital": "Paris"
    }, {
        "country": "French Guiana",
        "capital": "Cayenne"
    }, {
        "country": "French Polynesia",
        "capital": "Papeete"
    }, {
        "country": "French Southern and Antarctic Lands",
        "capital": "Martin-de-Vivi"
    }, {
        "country": "Gabon",
        "capital": "Libreville"
    }, {
        "country": "Gambia, The",
        "capital": "Banjul"
    }, {
        "country": "Georgia",
        "capital": "Tbilisi"
    }, {
        "country": "Germany",
        "capital": "Berlin"
    }, {
        "country": "Ghana",
        "capital": "Accra"
    }, {
        "country": "Gibraltar",
        "capital": "Gibraltar"
    }, {
        "country": "Greece",
        "capital": "Athens"
    }, {
        "country": "Greenland",
        "capital": "Nuuk (Godthab)"
    }, {
        "country": "Grenada",
        "capital": "Saint George's"
    }, {
        "country": "Guadeloupe",
        "capital": "Basse-Terre"
    }, {
        "country": "Guam",
        "capital": "Hagatna"
    }, {
        "country": "Guatemala",
        "capital": "Guatemala"
    }, {
        "country": "Guernsey",
        "capital": "Saint Peter Port"
    }, {
        "country": "Guinea",
        "capital": "Conakry"
    }, {
        "country": "Guinea-Bissau",
        "capital": "Bissau"
    }, {
        "country": "Guyana",
        "capital": "Georgetown"
    }, {
        "country": "Haiti",
        "capital": "Port-au-Prince"
    }, {
        "country": "Honduras",
        "capital": "Tegucigalpa"
    }, {
        "country": "Hungary",
        "capital": "Budapest"
    }, {
        "country": "Iceland",
        "capital": "Reykjavik"
    }, {
        "country": "India",
        "capital": "New Delhi"
    }, {
        "country": "Indonesia",
        "capital": "Jakarta"
    }, {
        "country": "Iran",
        "capital": "Tehran"
    }, {
        "country": "Iraq",
        "capital": "Baghdad"
    }, {
        "country": "Ireland",
        "capital": "Dublin"
    }, {
        "country": "Isle of Man",
        "capital": "Douglas"
    }, {
        "country": "Israel",
        "capital": "Jerusalem"
    }, {
        "country": "Italy",
        "capital": "Rome"
    }, {
        "country": "Jamaica",
        "capital": "Kingston"
    }, {
        "country": "Japan",
        "capital": "Tokyo"
    }, {
        "country": "Jersey",
        "capital": "Saint Helier"
    }, {
        "country": "Jordan",
        "capital": "Amman"
    }, {
        "country": "Kazakhstan",
        "capital": "Astana"
    }, {
        "country": "Kenya",
        "capital": "Nairobi"
    }, {
        "country": "Kiribati",
        "capital": "Tarawa"
    }, {
        "country": "Korea, Democratic People's Republic of (North Korea)",
        "capital": "Pyongyang"
    }, {
        "country": "Korea, Republic of  (South Korea)",
        "capital": "Seoul"
    }, {
        "country": "Kosovo",
        "capital": "Pristina"
    }, {
        "country": "Kuwait",
        "capital": "Kuwait"
    }, {
        "country": "Kyrgyzstan",
        "capital": "Bishkek"
    }, {
        "country": "Laos",
        "capital": "Vientiane"
    }, {
        "country": "Latvia",
        "capital": "Riga"
    }, {
        "country": "Lebanon",
        "capital": "Beirut"
    }, {
        "country": "Lesotho",
        "capital": "Maseru"
    }, {
        "country": "Liberia",
        "capital": "Monrovia"
    }, {
        "country": "Libya",
        "capital": "Tripoli"
    }, {
        "country": "Liechtenstein",
        "capital": "Vaduz"
    }, {
        "country": "Lithuania",
        "capital": "Vilnius"
    }, {
        "country": "Luxembourg",
        "capital": "Luxembourg"
    }, {
        "country": "Macau",
        "capital": "Macau"
    }, {
        "country": "Macedonia",
        "capital": "Skopje"
    }, {
        "country": "Madagascar",
        "capital": "Antananarivo"
    }, {
        "country": "Malawi",
        "capital": "Lilongwe"
    }, {
        "country": "Malaysia",
        "capital": "Kuala Lumpur (legislative/judical) and Putrajaya (administrative)"
    }, {
        "country": "Maldives",
        "capital": "Male"
    }, {
        "country": "Mali",
        "capital": "Bamako"
    }, {
        "country": "Malta",
        "capital": "Valletta"
    }, {
        "country": "Marshall Islands",
        "capital": "Majuro"
    }, {
        "country": "Martinique",
        "capital": "Fort-de-France"
    }, {
        "country": "Mauritania",
        "capital": "Nouakchott"
    }, {
        "country": "Mauritius",
        "capital": "Port Louis"
    }, {
        "country": "Mayotte",
        "capital": "Mamoudzou"
    }, {
        "country": "Mexico",
        "capital": "Mexico"
    }, {
        "country": "Micronesia",
        "capital": "Palikir"
    }, {
        "country": "Moldova",
        "capital": "Chisinau"
    }, {
        "country": "Monaco",
        "capital": "Monaco"
    }, {
        "country": "Mongolia",
        "capital": "Ulaanbaatar"
    }, {
        "country": "Montenegro",
        "capital": "Podgorica"
    }, {
        "country": "Montserrat",
        "capital": "Plymouth"
    }, {
        "country": "Morocco",
        "capital": "Rabat"
    }, {
        "country": "Mozambique",
        "capital": "Maputo"
    }, {
        "country": "Myanmar (Burma)",
        "capital": "Naypyidaw"
    }, {
        "country": "Nagorno-Karabakh",
        "capital": "Stepanakert"
    }, {
        "country": "Namibia",
        "capital": "Windhoek"
    }, {
        "country": "Nauru",
        "capital": "Yaren"
    }, {
        "country": "Nepal",
        "capital": "Kathmandu"
    }, {
        "country": "Netherlands",
        "capital": "Amsterdam (administrative) and The Hague (legislative/judical)"
    }, {
        "country": "Netherlands Antilles",
        "capital": "Willemstad"
    }, {
        "country": "New Caledonia",
        "capital": "Noumea"
    }, {
        "country": "New Zealand",
        "capital": "Wellington"
    }, {
        "country": "Nicaragua",
        "capital": "Managua"
    }, {
        "country": "Niger",
        "capital": "Niamey"
    }, {
        "country": "Nigeria",
        "capital": "Abuja"
    }, {
        "country": "Niue",
        "capital": "Alofi"
    }, {
        "country": "Norfolk Island",
        "capital": "Kingston"
    }, {
        "country": "Northern Cyprus",
        "capital": "Nicosia"
    }, {
        "country": "Northern Mariana Islands",
        "capital": "Saipan"
    }, {
        "country": "Norway",
        "capital": "Oslo"
    }, {
        "country": "Oman",
        "capital": "Muscat"
    }, {
        "country": "Pakistan",
        "capital": "Islamabad"
    }, {
        "country": "Palau",
        "capital": "Melekeok"
    }, {
        "country": "Palestinian Territories (Gaza Strip and West Bank)",
        "capital": "Gaza City (Gaza Strip) and Ramallah (West Bank)"
    }, {
        "country": "Panama",
        "capital": "Panama"
    }, {
        "country": "Papua New Guinea",
        "capital": "Port Moresby"
    }, {
        "country": "Paraguay",
        "capital": "Asuncion"
    }, {
        "country": "Peru",
        "capital": "Lima"
    }, {
        "country": "Philippines",
        "capital": "Manila"
    }, {
        "country": "Pitcairn Islands",
        "capital": "Adamstown"
    }, {
        "country": "Poland",
        "capital": "Warsaw"
    }, {
        "country": "Portugal",
        "capital": "Lisbon"
    }, {
        "country": "Pridnestrovie (Transnistria)",
        "capital": "Tiraspol"
    }, {
        "country": "Puerto Rico",
        "capital": "San Juan"
    }, {
        "country": "Qatar",
        "capital": "Doha"
    }, {
        "country": "Reunion",
        "capital": "Saint-Denis"
    }, {
        "country": "Romania",
        "capital": "Bucharest"
    }, {
        "country": "Russia",
        "capital": "Moscow"
    }, {
        "country": "Rwanda",
        "capital": "Kigali"
    }, {
        "country": "Saint Barthelemy",
        "capital": "Gustavia"
    }, {
        "country": "Saint Helena",
        "capital": "Jamestown"
    }, {
        "country": "Saint Kitts and Nevis",
        "capital": "Basseterre"
    }, {
        "country": "Saint Lucia",
        "capital": "Castries"
    }, {
        "country": "Saint Martin",
        "capital": "Marigot"
    }, {
        "country": "Saint Pierre and Miquelon",
        "capital": "Saint-Pierre"
    }, {
        "country": "Saint Vincent and the Grenadines",
        "capital": "Kingstown"
    }, {
        "country": "Samoa",
        "capital": "Apia"
    }, {
        "country": "San Marino",
        "capital": "San Marino"
    }, {
        "country": "Sao Tome and Principe",
        "capital": "Sao Tome"
    }, {
        "country": "Saudi Arabia",
        "capital": "Riyadh"
    }, {
        "country": "Senegal",
        "capital": "Dakar"
    }, {
        "country": "Serbia",
        "capital": "Belgrade"
    }, {
        "country": "Seychelles",
        "capital": "Victoria"
    }, {
        "country": "Sierra Leone",
        "capital": "Freetown"
    }, {
        "country": "Singapore",
        "capital": "Singapore"
    }, {
        "country": "Slovakia",
        "capital": "Bratislava"
    }, {
        "country": "Slovenia",
        "capital": "Ljubljana"
    }, {
        "country": "Solomon Islands",
        "capital": "Honiara"
    }, {
        "country": "Somalia",
        "capital": "Mogadishu"
    }, {
        "country": "Somaliland",
        "capital": "Hargeisa"
    }, {
        "country": "South Africa",
        "capital": "Pretoria (administrative), Cape Town (legislative), and Bloemfontein (judical)"
    }, {
        "country": "South Ossetia",
        "capital": "Tskhinvali"
    }, {
        "country": "Spain",
        "capital": "Madrid"
    }, {
        "country": "Sri Lanka",
        "capital": "Colombo (administrative/judical) and Sri Jayewardenepura Kotte (legislative)"
    }, {
        "country": "Sudan",
        "capital": "Khartoum"
    }, {
        "country": "Suriname",
        "capital": "Paramaribo"
    }, {
        "country": "Svalbard",
        "capital": "Longyearbyen"
    }, {
        "country": "Swaziland",
        "capital": "Mbabane (administrative) and Lobamba (legislative)"
    }, {
        "country": "Sweden",
        "capital": "Stockholm"
    }, {
        "country": "Switzerland",
        "capital": "Bern"
    }, {
        "country": "Syria",
        "capital": "Damascus"
    }, {
        "country": "Tajikistan",
        "capital": "Dushanbe"
    }, {
        "country": "Tanzania",
        "capital": "Dar es Salaam (administrative/judical) and Dodoma (legislative)"
    }, {
        "country": "Thailand",
        "capital": "Bangkok"
    }, {
        "country": "Timor-Leste (East Timor)",
        "capital": "Dili"
    }, {
        "country": "Togo",
        "capital": "Lome"
    }, {
        "country": "Tonga",
        "capital": "Nuku'alofa"
    }, {
        "country": "Trinidad and Tobago",
        "capital": "Port-of-Spain"
    }, {
        "country": "Tristan da Cunha",
        "capital": "Edinburgh"
    }, {
        "country": "Tunisia",
        "capital": "Tunis"
    }, {
        "country": "Turkey",
        "capital": "Ankara"
    }, {
        "country": "Turkmenistan",
        "capital": "Ashgabat"
    }, {
        "country": "Turks and Caicos Islands",
        "capital": "Grand Turk"
    }, {
        "country": "Tuvalu",
        "capital": "Funafuti"
    }, {
        "country": "U.S. Virgin Islands",
        "capital": "Charlotte Amalie"
    }, {
        "country": "Uganda",
        "capital": "Kampala"
    }, {
        "country": "Ukraine",
        "capital": "Kiev"
    }, {
        "country": "United Arab Emirates",
        "capital": "Abu Dhabi"
    }, {
        "country": "United Kingdom",
        "capital": "London"
    }, {
        "country": "United States",
        "capital": "Washington"
    }, {
        "country": "Uruguay",
        "capital": "Montevideo"
    }, {
        "country": "Uzbekistan",
        "capital": "Tashkent"
    }, {
        "country": "Vanuatu",
        "capital": "Port-Vila"
    }, {
        "country": "Vatican City",
        "capital": "Vatican City"
    }, {
        "country": "Venezuela",
        "capital": "Caracas"
    }, {
        "country": "Vietnam",
        "capital": "Hanoi"
    }, {
        "country": "Wallis and Futuna",
        "capital": "Mata'utu"
    }, {
        "country": "Western Sahara",
        "capital": "El-Aaiun"
    }, {
        "country": "Yemen",
        "capital": "Sanaa"
    }, {
        "country": "Zambia",
        "capital": "Lusaka"
    }, {
        "country": "Zimbabwe",
        "capital": "Harare"
    }]
});