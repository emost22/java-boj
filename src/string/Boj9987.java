package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9987 {
    static String list[] = new String[718];
    static int N;

    static void init() {
        list[0] = "Bulbasaur\nGrass Poison";
        list[1] = "Ivysaur\nGrass Poison";
        list[2] = "Venusaur\nGrass Poison";
        list[3] = "Charmander\nFire";
        list[4] = "Charmeleon\nFire";
        list[5] = "Charizard\nFire Flying";
        list[6] = "Squirtle\nWater";
        list[7] = "Wartortle\nWater";
        list[8] = "Blastoise\nWater";
        list[9] = "Caterpie\nBug";
        list[10] = "Metapod\nBug";
        list[11] = "Butterfree\nBug Flying";
        list[12] = "Weedle\nBug Poison";
        list[13] = "Kakuna\nBug Poison";
        list[14] = "Beedrill\nBug Poison";
        list[15] = "Pidgey\nNormal Flying";
        list[16] = "Pidgeotto\nNormal Flying";
        list[17] = "Pidgeot\nNormal Flying";
        list[18] = "Rattata\nNormal";
        list[19] = "Raticate\nNormal";
        list[20] = "Spearow\nNormal Flying";
        list[21] = "Fearow\nNormal Flying";
        list[22] = "Ekans\nPoison";
        list[23] = "Arbok\nPoison";
        list[24] = "Pikachu\nElectric";
        list[25] = "Raichu\nElectric";
        list[26] = "Sandshrew\nGround";
        list[27] = "Sandslash\nGround";
        list[28] = "Nidoran♀\nPoison";
        list[29] = "Nidorina\nPoison";
        list[30] = "Nidoqueen\nPoison Ground";
        list[31] = "Nidoran♂\nPoison";
        list[32] = "Nidorino\nPoison";
        list[33] = "Nidoking\nPoison Ground";
        list[34] = "Clefairy\nFairy";
        list[35] = "Clefable\nFairy";
        list[36] = "Vulpix\nFire";
        list[37] = "Ninetales\nFire";
        list[38] = "Jigglypuff\nNormal Fairy";
        list[39] = "Wigglytuff\nNormal Fairy";
        list[40] = "Zubat\nPoison Flying";
        list[41] = "Golbat\nPoison Flying";
        list[42] = "Oddish\nGrass Poison";
        list[43] = "Gloom\nGrass Poison";
        list[44] = "Vileplume\nGrass Poison";
        list[45] = "Paras\nBug Grass";
        list[46] = "Parasect\nBug Grass";
        list[47] = "Venonat\nBug Poison";
        list[48] = "Venomoth\nBug Poison";
        list[49] = "Diglett\nGround";
        list[50] = "Dugtrio\nGround";
        list[51] = "Meowth\nNormal";
        list[52] = "Persian\nNormal";
        list[53] = "Psyduck\nWater";
        list[54] = "Golduck\nWater";
        list[55] = "Mankey\nFighting";
        list[56] = "Primeape\nFighting";
        list[57] = "Growlithe\nFire";
        list[58] = "Arcanine\nFire";
        list[59] = "Poliwag\nWater";
        list[60] = "Poliwhirl\nWater";
        list[61] = "Poliwrath\nWater Fighting";
        list[62] = "Abra\nPsychic";
        list[63] = "Kadabra\nPsychic";
        list[64] = "Alakazam\nPsychic";
        list[65] = "Machop\nFighting";
        list[66] = "Machoke\nFighting";
        list[67] = "Machamp\nFighting";
        list[68] = "Bellsprout\nGrass Poison";
        list[69] = "Weepinbell\nGrass Poison";
        list[70] = "Victreebel\nGrass Poison";
        list[71] = "Tentacool\nWater Poison";
        list[72] = "Tentacruel\nWater Poison";
        list[73] = "Geodude\nRock Ground";
        list[74] = "Graveler\nRock Ground";
        list[75] = "Golem\nRock Ground";
        list[76] = "Ponyta\nFire";
        list[77] = "Rapidash\nFire";
        list[78] = "Slowpoke\nWater Psychic";
        list[79] = "Slowbro\nWater Psychic";
        list[80] = "Magnemite\nElectric Steel";
        list[81] = "Magneton\nElectric Steel";
        list[82] = "Farfetch'd\nNormal Flying";
        list[83] = "Doduo\nNormal Flying";
        list[84] = "Dodrio\nNormal Flying";
        list[85] = "Seel\nWater";
        list[86] = "Dewgong\nWater Ice";
        list[87] = "Grimer\nPoison";
        list[88] = "Muk\nPoison";
        list[89] = "Shellder\nWater";
        list[90] = "Cloyster\nWater Ice";
        list[91] = "Gastly\nGhost Poison";
        list[92] = "Haunter\nGhost Poison";
        list[93] = "Gengar\nGhost Poison";
        list[94] = "Onix\nRock Ground";
        list[95] = "Drowzee\nPsychic";
        list[96] = "Hypno\nPsychic";
        list[97] = "Krabby\nWater";
        list[98] = "Kingler\nWater";
        list[99] = "Voltorb\nElectric";
        list[100] = "Electrode\nElectric";
        list[101] = "Exeggcute\nGrass Psychic";
        list[102] = "Exeggutor\nGrass Psychic";
        list[103] = "Cubone\nGround";
        list[104] = "Marowak\nGround";
        list[105] = "Hitmonlee\nFighting";
        list[106] = "Hitmonchan\nFighting";
        list[107] = "Lickitung\nNormal";
        list[108] = "Koffing\nPoison";
        list[109] = "Weezing\nPoison";
        list[110] = "Rhyhorn\nGround Rock";
        list[111] = "Rhydon\nGround Rock";
        list[112] = "Chansey\nNormal";
        list[113] = "Tangela\nGrass";
        list[114] = "Kangaskhan\nNormal";
        list[115] = "Horsea\nWater";
        list[116] = "Seadra\nWater";
        list[117] = "Goldeen\nWater";
        list[118] = "Seaking\nWater";
        list[119] = "Staryu\nWater";
        list[120] = "Starmie\nWater Psychic";
        list[121] = "Mr. Mime\nPsychic Fairy";
        list[122] = "Scyther\nBug Flying";
        list[123] = "Jynx\nIce Psychic";
        list[124] = "Electabuzz\nElectric";
        list[125] = "Magmar\nFire";
        list[126] = "Pinsir\nBug";
        list[127] = "Tauros\nNormal";
        list[128] = "Magikarp\nWater";
        list[129] = "Gyarados\nWater Flying";
        list[130] = "Lapras\nWater Ice";
        list[131] = "Ditto\nNormal";
        list[132] = "Eevee\nNormal";
        list[133] = "Vaporeon\nWater";
        list[134] = "Jolteon\nElectric";
        list[135] = "Flareon\nFire";
        list[136] = "Porygon\nNormal";
        list[137] = "Omanyte\nRock Water";
        list[138] = "Omastar\nRock Water";
        list[139] = "Kabuto\nRock Water";
        list[140] = "Kabutops\nRock Water";
        list[141] = "Aerodactyl\nRock Flying";
        list[142] = "Snorlax\nNormal";
        list[143] = "Articuno\nIce Flying";
        list[144] = "Zapdos\nElectric Flying";
        list[145] = "Moltres\nFire Flying";
        list[146] = "Dratini\nDragon";
        list[147] = "Dragonair\nDragon";
        list[148] = "Dragonite\nDragon Flying";
        list[149] = "Mewtwo\nPsychic";
        list[150] = "Mew\nPsychic";
        list[151] = "Chikorita\nGrass";
        list[152] = "Bayleef\nGrass";
        list[153] = "Meganium\nGrass";
        list[154] = "Cyndaquil\nFire";
        list[155] = "Quilava\nFire";
        list[156] = "Typhlosion\nFire";
        list[157] = "Totodile\nWater";
        list[158] = "Croconaw\nWater";
        list[159] = "Feraligatr\nWater";
        list[160] = "Sentret\nNormal";
        list[161] = "Furret\nNormal";
        list[162] = "Hoothoot\nNormal Flying";
        list[163] = "Noctowl\nNormal Flying";
        list[164] = "Ledyba\nBug Flying";
        list[165] = "Ledian\nBug Flying";
        list[166] = "Spinarak\nBug Poison";
        list[167] = "Ariados\nBug Poison";
        list[168] = "Crobat\nPoison Flying";
        list[169] = "Chinchou\nWater Electric";
        list[170] = "Lanturn\nWater Electric";
        list[171] = "Pichu\nElectric";
        list[172] = "Cleffa\nFairy";
        list[173] = "Igglybuff\nNormal Fairy";
        list[174] = "Togepi\nFairy";
        list[175] = "Togetic\nFairy Flying";
        list[176] = "Natu\nPsychic Flying";
        list[177] = "Xatu\nPsychic Flying";
        list[178] = "Mareep\nElectric";
        list[179] = "Flaaffy\nElectric";
        list[180] = "Ampharos\nElectric";
        list[181] = "Bellossom\nGrass";
        list[182] = "Marill\nWater Fairy";
        list[183] = "Azumarill\nWater Fairy";
        list[184] = "Sudowoodo\nRock";
        list[185] = "Politoed\nWater";
        list[186] = "Hoppip\nGrass Flying";
        list[187] = "Skiploom\nGrass Flying";
        list[188] = "Jumpluff\nGrass Flying";
        list[189] = "Aipom\nNormal";
        list[190] = "Sunkern\nGrass";
        list[191] = "Sunflora\nGrass";
        list[192] = "Yanma\nBug Flying";
        list[193] = "Wooper\nWater Ground";
        list[194] = "Quagsire\nWater Ground";
        list[195] = "Espeon\nPsychic";
        list[196] = "Umbreon\nDark";
        list[197] = "Murkrow\nDark Flying";
        list[198] = "Slowking\nWater Psychic";
        list[199] = "Misdreavus\nGhost";
        list[200] = "Unown\nPsychic";
        list[201] = "Wobbuffet\nPsychic";
        list[202] = "Girafarig\nNormal Psychic";
        list[203] = "Pineco\nBug";
        list[204] = "Forretress\nBug Steel";
        list[205] = "Dunsparce\nNormal";
        list[206] = "Gligar\nGround Flying";
        list[207] = "Steelix\nSteel Ground";
        list[208] = "Snubbull\nFairy";
        list[209] = "Granbull\nFairy";
        list[210] = "Qwilfish\nWater Poison";
        list[211] = "Scizor\nBug Steel";
        list[212] = "Shuckle\nBug Rock";
        list[213] = "Heracross\nBug Fighting";
        list[214] = "Sneasel\nDark Ice";
        list[215] = "Teddiursa\nNormal";
        list[216] = "Ursaring\nNormal";
        list[217] = "Slugma\nFire";
        list[218] = "Magcargo\nFire Rock";
        list[219] = "Swinub\nIce Ground";
        list[220] = "Piloswine\nIce Ground";
        list[221] = "Corsola\nWater Rock";
        list[222] = "Remoraid\nWater";
        list[223] = "Octillery\nWater";
        list[224] = "Delibird\nIce Flying";
        list[225] = "Mantine\nWater Flying";
        list[226] = "Skarmory\nSteel Flying";
        list[227] = "Houndour\nDark Fire";
        list[228] = "Houndoom\nDark Fire";
        list[229] = "Kingdra\nWater Dragon";
        list[230] = "Phanpy\nGround";
        list[231] = "Donphan\nGround";
        list[232] = "Porygon2\nNormal";
        list[233] = "Stantler\nNormal";
        list[234] = "Smeargle\nNormal";
        list[235] = "Tyrogue\nFighting";
        list[236] = "Hitmontop\nFighting";
        list[237] = "Smoochum\nIce Psychic";
        list[238] = "Elekid\nElectric";
        list[239] = "Magby\nFire";
        list[240] = "Miltank\nNormal";
        list[241] = "Blissey\nNormal";
        list[242] = "Raikou\nElectric";
        list[243] = "Entei\nFire";
        list[244] = "Suicune\nWater";
        list[245] = "Larvitar\nRock Ground";
        list[246] = "Pupitar\nRock Ground";
        list[247] = "Tyranitar\nRock Dark";
        list[248] = "Lugia\nPsychic Flying";
        list[249] = "Ho-oh\nFire Flying";
        list[250] = "Celebi\nPsychic Grass";
        list[251] = "Treecko\nGrass";
        list[252] = "Grovyle\nGrass";
        list[253] = "Sceptile\nGrass";
        list[254] = "Torchic\nFire";
        list[255] = "Combusken\nFire Fighting";
        list[256] = "Blaziken\nFire Fighting";
        list[257] = "Mudkip\nWater";
        list[258] = "Marshtomp\nWater Ground";
        list[259] = "Swampert\nWater Ground";
        list[260] = "Poochyena\nDark";
        list[261] = "Mightyena\nDark";
        list[262] = "Zigzagoon\nNormal";
        list[263] = "Linoone\nNormal";
        list[264] = "Wurmple\nBug";
        list[265] = "Silcoon\nBug";
        list[266] = "Beautifly\nBug Flying";
        list[267] = "Cascoon\nBug";
        list[268] = "Dustox\nBug Poison";
        list[269] = "Lotad\nWater Grass";
        list[270] = "Lombre\nWater Grass";
        list[271] = "Ludicolo\nWater Grass";
        list[272] = "Seedot\nGrass";
        list[273] = "Nuzleaf\nGrass Dark";
        list[274] = "Shiftry\nGrass Dark";
        list[275] = "Taillow\nNormal Flying";
        list[276] = "Swellow\nNormal Flying";
        list[277] = "Wingull\nWater Flying";
        list[278] = "Pelipper\nWater Flying";
        list[279] = "Ralts\nPsychic Fairy";
        list[280] = "Kirlia\nPsychic Fairy";
        list[281] = "Gardevoir\nPsychic Fairy";
        list[282] = "Surskit\nBug Water";
        list[283] = "Masquerain\nBug Flying";
        list[284] = "Shroomish\nGrass";
        list[285] = "Breloom\nGrass Fighting";
        list[286] = "Slakoth\nNormal";
        list[287] = "Vigoroth\nNormal";
        list[288] = "Slaking\nNormal";
        list[289] = "Nincada\nBug Ground";
        list[290] = "Ninjask\nBug Flying";
        list[291] = "Shedinja\nBug Ghost";
        list[292] = "Whismur\nNormal";
        list[293] = "Loudred\nNormal";
        list[294] = "Exploud\nNormal";
        list[295] = "Makuhita\nFighting";
        list[296] = "Hariyama\nFighting";
        list[297] = "Azurill\nNormal Fairy";
        list[298] = "Nosepass\nRock";
        list[299] = "Skitty\nNormal";
        list[300] = "Delcatty\nNormal";
        list[301] = "Sableye\nDark Ghost";
        list[302] = "Mawile\nSteel Fairy";
        list[303] = "Aron\nSteel Rock";
        list[304] = "Lairon\nSteel Rock";
        list[305] = "Aggron\nSteel Rock";
        list[306] = "Meditite\nFighting Psychic";
        list[307] = "Medicham\nFighting Psychic";
        list[308] = "Electrike\nElectric";
        list[309] = "Manectric\nElectric";
        list[310] = "Plusle\nElectric";
        list[311] = "Minun\nElectric";
        list[312] = "Volbeat\nBug";
        list[313] = "Illumise\nBug";
        list[314] = "Roselia\nGrass Poison";
        list[315] = "Gulpin\nPoison";
        list[316] = "Swalot\nPoison";
        list[317] = "Carvanha\nWater Dark";
        list[318] = "Sharpedo\nWater Dark";
        list[319] = "Wailmer\nWater";
        list[320] = "Wailord\nWater";
        list[321] = "Numel\nFire Ground";
        list[322] = "Camerupt\nFire Ground";
        list[323] = "Torkoal\nFire";
        list[324] = "Spoink\nPsychic";
        list[325] = "Grumpig\nPsychic";
        list[326] = "Spinda\nNormal";
        list[327] = "Trapinch\nGround";
        list[328] = "Vibrava\nGround Dragon";
        list[329] = "Flygon\nGround Dragon";
        list[330] = "Cacnea\nGrass";
        list[331] = "Cacturne\nGrass Dark";
        list[332] = "Swablu\nNormal Flying";
        list[333] = "Altaria\nDragon Flying";
        list[334] = "Zangoose\nNormal";
        list[335] = "Seviper\nPoison";
        list[336] = "Lunatone\nRock Psychic";
        list[337] = "Solrock\nRock Psychic";
        list[338] = "Barboach\nWater Ground";
        list[339] = "Whiscash\nWater Ground";
        list[340] = "Corphish\nWater";
        list[341] = "Crawdaunt\nWater Dark";
        list[342] = "Baltoy\nGround Psychic";
        list[343] = "Claydol\nGround Psychic";
        list[344] = "Lileep\nRock Grass";
        list[345] = "Cradily\nRock Grass";
        list[346] = "Anorith\nRock Bug";
        list[347] = "Armaldo\nRock Bug";
        list[348] = "Feebas\nWater";
        list[349] = "Milotic\nWater";
        list[350] = "Castform\nNormal";
        list[351] = "Kecleon\nNormal";
        list[352] = "Shuppet\nGhost";
        list[353] = "Banette\nGhost";
        list[354] = "Duskull\nGhost";
        list[355] = "Dusclops\nGhost";
        list[356] = "Tropius\nGrass Flying";
        list[357] = "Chimecho\nPsychic";
        list[358] = "Absol\nDark";
        list[359] = "Wynaut\nPsychic";
        list[360] = "Snorunt\nIce";
        list[361] = "Glalie\nIce";
        list[362] = "Spheal\nIce Water";
        list[363] = "Sealeo\nIce Water";
        list[364] = "Walrein\nIce Water";
        list[365] = "Clamperl\nWater";
        list[366] = "Huntail\nWater";
        list[367] = "Gorebyss\nWater";
        list[368] = "Relicanth\nWater Rock";
        list[369] = "Luvdisc\nWater";
        list[370] = "Bagon\nDragon";
        list[371] = "Shelgon\nDragon";
        list[372] = "Salamence\nDragon Flying";
        list[373] = "Beldum\nSteel Psychic";
        list[374] = "Metang\nSteel Psychic";
        list[375] = "Metagross\nSteel Psychic";
        list[376] = "Regirock\nRock";
        list[377] = "Regice\nIce";
        list[378] = "Registeel\nSteel";
        list[379] = "Latias\nDragon Psychic";
        list[380] = "Latios\nDragon Psychic";
        list[381] = "Kyogre\nWater";
        list[382] = "Groudon\nGround";
        list[383] = "Rayquaza\nDragon Flying";
        list[384] = "Jirachi\nSteel Psychic";
        list[385] = "Deoxys\nPsychic";
        list[386] = "Turtwig\nGrass";
        list[387] = "Grotle\nGrass";
        list[388] = "Torterra\nGrass Ground";
        list[389] = "Chimchar\nFire";
        list[390] = "Monferno\nFire Fighting";
        list[391] = "Infernape\nFire Fighting";
        list[392] = "Piplup\nWater";
        list[393] = "Prinplup\nWater";
        list[394] = "Empoleon\nWater Steel";
        list[395] = "Starly\nNormal Flying";
        list[396] = "Staravia\nNormal Flying";
        list[397] = "Staraptor\nNormal Flying";
        list[398] = "Bidoof\nNormal";
        list[399] = "Bibarel\nNormal Water";
        list[400] = "Kricketot\nBug";
        list[401] = "Kricketune\nBug";
        list[402] = "Shinx\nElectric";
        list[403] = "Luxio\nElectric";
        list[404] = "Luxray\nElectric";
        list[405] = "Budew\nGrass Poison";
        list[406] = "Roserade\nGrass Poison";
        list[407] = "Cranidos\nRock";
        list[408] = "Rampardos\nRock";
        list[409] = "Shieldon\nRock Steel";
        list[410] = "Bastiodon\nRock Steel";
        list[411] = "Burmy\nBug";
        list[412] = "Wormadam\nBug Grass";
        list[413] = "Mothim\nBug Flying";
        list[414] = "Combee\nBug Flying";
        list[415] = "Vespiquen\nBug Flying";
        list[416] = "Pachirisu\nElectric";
        list[417] = "Buizel\nWater";
        list[418] = "Floatzel\nWater";
        list[419] = "Cherubi\nGrass";
        list[420] = "Cherrim\nGrass";
        list[421] = "Shellos\nWater";
        list[422] = "Gastrodon\nWater Ground";
        list[423] = "Ambipom\nNormal";
        list[424] = "Drifloon\nGhost Flying";
        list[425] = "Drifblim\nGhost Flying";
        list[426] = "Buneary\nNormal";
        list[427] = "Lopunny\nNormal";
        list[428] = "Mismagius\nGhost";
        list[429] = "Honchkrow\nDark Flying";
        list[430] = "Glameow\nNormal";
        list[431] = "Purugly\nNormal";
        list[432] = "Chingling\nPsychic";
        list[433] = "Stunky\nPoison Dark";
        list[434] = "Skuntank\nPoison Dark";
        list[435] = "Bronzor\nSteel Psychic";
        list[436] = "Bronzong\nSteel Psychic";
        list[437] = "Bonsly\nRock";
        list[438] = "Mime Jr.\nPsychic Fairy";
        list[439] = "Happiny\nNormal";
        list[440] = "Chatot\nNormal Flying";
        list[441] = "Spiritomb\nGhost Dark";
        list[442] = "Gible\nDragon Ground";
        list[443] = "Gabite\nDragon Ground";
        list[444] = "Garchomp\nDragon Ground";
        list[445] = "Munchlax\nNormal";
        list[446] = "Riolu\nFighting";
        list[447] = "Lucario\nFighting Steel";
        list[448] = "Hippopotas\nGround";
        list[449] = "Hippowdon\nGround";
        list[450] = "Skorupi\nPoison Bug";
        list[451] = "Drapion\nPoison Dark";
        list[452] = "Croagunk\nPoison Fighting";
        list[453] = "Toxicroak\nPoison Fighting";
        list[454] = "Carnivine\nGrass";
        list[455] = "Finneon\nWater";
        list[456] = "Lumineon\nWater";
        list[457] = "Mantyke\nWater Flying";
        list[458] = "Snover\nGrass Ice";
        list[459] = "Abomasnow\nGrass Ice";
        list[460] = "Weavile\nDark Ice";
        list[461] = "Magnezone\nElectric Steel";
        list[462] = "Lickilicky\nNormal";
        list[463] = "Rhyperior\nGround Rock";
        list[464] = "Tangrowth\nGrass";
        list[465] = "Electivire\nElectric";
        list[466] = "Magmortar\nFire";
        list[467] = "Togekiss\nFairy Flying";
        list[468] = "Yanmega\nBug Flying";
        list[469] = "Leafeon\nGrass";
        list[470] = "Glaceon\nIce";
        list[471] = "Gliscor\nGround Flying";
        list[472] = "Mamoswine\nIce Ground";
        list[473] = "Porygon-Z\nNormal";
        list[474] = "Gallade\nPsychic Fighting";
        list[475] = "Probopass\nRock Steel";
        list[476] = "Dusknoir\nGhost";
        list[477] = "Froslass\nIce Ghost";
        list[478] = "Rotom\nElectric Ghost";
        list[479] = "Uxie\nPsychic";
        list[480] = "Mesprit\nPsychic";
        list[481] = "Azelf\nPsychic";
        list[482] = "Dialga\nSteel Dragon";
        list[483] = "Palkia\nWater Dragon";
        list[484] = "Heatran\nFire Steel";
        list[485] = "Regigigas\nNormal";
        list[486] = "Giratina\nGhost Dragon";
        list[487] = "Cresselia\nPsychic";
        list[488] = "Phione\nWater";
        list[489] = "Manaphy\nWater";
        list[490] = "Darkrai\nDark";
        list[491] = "Shaymin\nGrass";
        list[492] = "Arceus\nNormal";
        list[493] = "Victini\nPsychic Fire";
        list[494] = "Snivy\nGrass";
        list[495] = "Servine\nGrass";
        list[496] = "Serperior\nGrass";
        list[497] = "Tepig\nFire";
        list[498] = "Pignite\nFire Fighting";
        list[499] = "Emboar\nFire Fighting";
        list[500] = "Oshawott\nWater";
        list[501] = "Dewott\nWater";
        list[502] = "Samurott\nWater";
        list[503] = "Patrat\nNormal";
        list[504] = "Watchog\nNormal";
        list[505] = "Lillipup\nNormal";
        list[506] = "Herdier\nNormal";
        list[507] = "Stoutland\nNormal";
        list[508] = "Purrloin\nDark";
        list[509] = "Liepard\nDark";
        list[510] = "Pansage\nGrass";
        list[511] = "Simisage\nGrass";
        list[512] = "Pansear\nFire";
        list[513] = "Simisear\nFire";
        list[514] = "Panpour\nWater";
        list[515] = "Simipour\nWater";
        list[516] = "Munna\nPsychic";
        list[517] = "Musharna\nPsychic";
        list[518] = "Pidove\nNormal Flying";
        list[519] = "Tranquill\nNormal Flying";
        list[520] = "Unfezant\nNormal Flying";
        list[521] = "Blitzle\nElectric";
        list[522] = "Zebstrika\nElectric";
        list[523] = "Roggenrola\nRock";
        list[524] = "Boldore\nRock";
        list[525] = "Gigalith\nRock";
        list[526] = "Woobat\nPsychic Flying";
        list[527] = "Swoobat\nPsychic Flying";
        list[528] = "Drilbur\nGround";
        list[529] = "Excadrill\nGround Steel";
        list[530] = "Audino\nNormal";
        list[531] = "Timburr\nFighting";
        list[532] = "Gurdurr\nFighting";
        list[533] = "Conkeldurr\nFighting";
        list[534] = "Tympole\nWater";
        list[535] = "Palpitoad\nWater Ground";
        list[536] = "Seismitoad\nWater Ground";
        list[537] = "Throh\nFighting";
        list[538] = "Sawk\nFighting";
        list[539] = "Sewaddle\nBug Grass";
        list[540] = "Swadloon\nBug Grass";
        list[541] = "Leavanny\nBug Grass";
        list[542] = "Venipede\nBug Poison";
        list[543] = "Whirlipede\nBug Poison";
        list[544] = "Scolipede\nBug Poison";
        list[545] = "Cottonee\nGrass Fairy";
        list[546] = "Whimsicott\nGrass Fairy";
        list[547] = "Petilil\nGrass";
        list[548] = "Lilligant\nGrass";
        list[549] = "Basculin\nWater";
        list[550] = "Sandile\nGround Dark";
        list[551] = "Krokorok\nGround Dark";
        list[552] = "Krookodile\nGround Dark";
        list[553] = "Darumaka\nFire";
        list[554] = "Darmanitan\nFire";
        list[555] = "Maractus\nGrass";
        list[556] = "Dwebble\nBug Rock";
        list[557] = "Crustle\nBug Rock";
        list[558] = "Scraggy\nDark Fighting";
        list[559] = "Scrafty\nDark Fighting";
        list[560] = "Sigilyph\nPsychic Flying";
        list[561] = "Yamask\nGhost";
        list[562] = "Cofagrigus\nGhost";
        list[563] = "Tirtouga\nWater Rock";
        list[564] = "Carracosta\nWater Rock";
        list[565] = "Archen\nRock Flying";
        list[566] = "Archeops\nRock Flying";
        list[567] = "Trubbish\nPoison";
        list[568] = "Garbodor\nPoison";
        list[569] = "Zorua\nDark";
        list[570] = "Zoroark\nDark";
        list[571] = "Minccino\nNormal";
        list[572] = "Cinccino\nNormal";
        list[573] = "Gothita\nPsychic";
        list[574] = "Gothorita\nPsychic";
        list[575] = "Gothitelle\nPsychic";
        list[576] = "Solosis\nPsychic";
        list[577] = "Duosion\nPsychic";
        list[578] = "Reuniclus\nPsychic";
        list[579] = "Ducklett\nWater Flying";
        list[580] = "Swanna\nWater Flying";
        list[581] = "Vanillite\nIce";
        list[582] = "Vanillish\nIce";
        list[583] = "Vanilluxe\nIce";
        list[584] = "Deerling\nNormal Grass";
        list[585] = "Sawsbuck\nNormal Grass";
        list[586] = "Emolga\nElectric Flying";
        list[587] = "Karrablast\nBug";
        list[588] = "Escavalier\nBug Steel";
        list[589] = "Foongus\nGrass Poison";
        list[590] = "Amoonguss\nGrass Poison";
        list[591] = "Frillish\nWater Ghost";
        list[592] = "Jellicent\nWater Ghost";
        list[593] = "Alomomola\nWater";
        list[594] = "Joltik\nBug Electric";
        list[595] = "Galvantula\nBug Electric";
        list[596] = "Ferroseed\nGrass Steel";
        list[597] = "Ferrothorn\nGrass Steel";
        list[598] = "Klink\nSteel";
        list[599] = "Klang\nSteel";
        list[600] = "Klinklang\nSteel";
        list[601] = "Tynamo\nElectric";
        list[602] = "Eelektrik\nElectric";
        list[603] = "Eelektross\nElectric";
        list[604] = "Elgyem\nPsychic";
        list[605] = "Beheeyem\nPsychic";
        list[606] = "Litwick\nGhost Fire";
        list[607] = "Lampent\nGhost Fire";
        list[608] = "Chandelure\nGhost Fire";
        list[609] = "Axew\nDragon";
        list[610] = "Fraxure\nDragon";
        list[611] = "Haxorus\nDragon";
        list[612] = "Cubchoo\nIce";
        list[613] = "Beartic\nIce";
        list[614] = "Cryogonal\nIce";
        list[615] = "Shelmet\nBug";
        list[616] = "Accelgor\nBug";
        list[617] = "Stunfisk\nElectric Ground";
        list[618] = "Mienfoo\nFighting";
        list[619] = "Mienshao\nFighting";
        list[620] = "Druddigon\nDragon";
        list[621] = "Golett\nGround Ghost";
        list[622] = "Golurk\nGround Ghost";
        list[623] = "Pawniard\nDark Steel";
        list[624] = "Bisharp\nDark Steel";
        list[625] = "Bouffalant\nNormal";
        list[626] = "Rufflet\nNormal Flying";
        list[627] = "Braviary\nNormal Flying";
        list[628] = "Vullaby\nDark Flying";
        list[629] = "Mandibuzz\nDark Flying";
        list[630] = "Heatmor\nFire";
        list[631] = "Durant\nBug Steel";
        list[632] = "Deino\nDark Dragon";
        list[633] = "Zweilous\nDark Dragon";
        list[634] = "Hydreigon\nDark Dragon";
        list[635] = "Larvesta\nBug Fire";
        list[636] = "Volcarona\nBug Fire";
        list[637] = "Cobalion\nSteel Fighting";
        list[638] = "Terrakion\nRock Fighting";
        list[639] = "Virizion\nGrass Fighting";
        list[640] = "Tornadus\nFlying";
        list[641] = "Thundurus\nElectric Flying";
        list[642] = "Reshiram\nDragon Fire";
        list[643] = "Zekrom\nDragon Electric";
        list[644] = "Landorus\nGround Flying";
        list[645] = "Kyurem\nDragon Ice";
        list[646] = "Keldeo\nWater Fighting";
        list[647] = "Meloetta\nNormal Psychic";
        list[648] = "Genesect\nBug Steel";
        list[649] = "Chespin\nGrass";
        list[650] = "Quilladin\nGrass";
        list[651] = "Chesnaught\nGrass Fighting";
        list[652] = "Fennekin\nFire";
        list[653] = "Braixen\nFire";
        list[654] = "Delphox\nFire Psychic";
        list[655] = "Froakie\nWater";
        list[656] = "Frogadier\nWater";
        list[657] = "Greninja\nWater Dark";
        list[658] = "Bunnelby\nNormal";
        list[659] = "Diggersby\nNormal Ground";
        list[660] = "Fletchling\nNormal Flying";
        list[661] = "Fletchinder\nFire Flying";
        list[662] = "Talonflame\nFire Flying";
        list[663] = "Scatterbug\nBug";
        list[664] = "Spewpa\nBug";
        list[665] = "Vivillon\nBug Flying";
        list[666] = "Litleo\nFire Normal";
        list[667] = "Pyroar\nFire Normal";
        list[668] = "Flabébé\nFairy";
        list[669] = "Floette\nFairy";
        list[670] = "Florges\nFairy";
        list[671] = "Skiddo\nGrass";
        list[672] = "Gogoat\nGrass";
        list[673] = "Pancham\nFighting";
        list[674] = "Pangoro\nFighting Dark";
        list[675] = "Furfrou\nNormal";
        list[676] = "Espurr\nPsychic";
        list[677] = "Meowstic\nPsychic";
        list[678] = "Honedge\nSteel Ghost";
        list[679] = "Doublade\nSteel Ghost";
        list[680] = "Aegislash\nSteel Ghost";
        list[681] = "Spritzee\nFairy";
        list[682] = "Aromatisse\nFairy";
        list[683] = "Swirlix\nFairy";
        list[684] = "Slurpuff\nFairy";
        list[685] = "Inkay\nDark Psychic";
        list[686] = "Malamar\nDark Psychic";
        list[687] = "Binacle\nRock Water";
        list[688] = "Barbaracle\nRock Water";
        list[689] = "Skrelp\nPoison Water";
        list[690] = "Dragalge\nPoison Dragon";
        list[691] = "Clauncher\nWater";
        list[692] = "Clawitzer\nWater";
        list[693] = "Helioptile\nElectric Normal";
        list[694] = "Heliolisk\nElectric Normal";
        list[695] = "Tyrunt\nRock Dragon";
        list[696] = "Tyrantrum\nRock Dragon";
        list[697] = "Amaura\nRock Ice";
        list[698] = "Aurorus\nRock Ice";
        list[699] = "Sylveon\nFairy";
        list[700] = "Hawlucha\nFighting Flying";
        list[701] = "Dedenne\nElectric Fairy";
        list[702] = "Carbink\nRock Fairy";
        list[703] = "Goomy\nDragon";
        list[704] = "Sliggoo\nDragon";
        list[705] = "Goodra\nDragon";
        list[706] = "Klefki\nSteel Fairy";
        list[707] = "Phantump\nGhost Grass";
        list[708] = "Trevenant\nGhost Grass";
        list[709] = "Pumpkaboo\nGhost Grass";
        list[710] = "Gourgeist\nGhost Grass";
        list[711] = "Bergmite\nIce";
        list[712] = "Avalugg\nIce";
        list[713] = "Noibat\nFlying Dragon";
        list[714] = "Noivern\nFlying Dragon";
        list[715] = "Xerneas\nFairy";
        list[716] = "Yveltal\nDark Flying";
        list[717] = "Zygarde\nDragon Ground";
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        System.out.println(list[N - 1]);
    }

    public static void main(String[] args) throws Exception {
        init();
        input();
    }
}
