#1
mkdir lab0
cd lab0

mkdir eevee5
cd eevee5
mkdir archen
touch misdreavus deerling growlithe pidove spearow
cd ..

mkdir excadrill0
cd excadrill0
mkdir simipour azurill
touch swinub munchlax doduo bronzing
cd ..

touch gloom1

mkdir onix2
cd onix2
touch clefable blissey mightyena
cd ..

touch seadra8 shedinja3

cd eevee5
echo 'Развитые способности Cursed Body' > misdreavus
echo -e 'Способности\nCamouflage Tackle Growl Sand-Attack Double Kick Leech Seed Faint\nAttack Take Down Jump Kick Aromatherapy Energy Ball Charm Nature Power' > deerling
echo -e 'weight=41.9 height=28.0 atk=7\ndef5' > growlithe
echo -e 'Развитые способности Rivalry' > pidove
echo -e 'Тип диеты\nOmivore' > spearow
cd ..

cd excadrill0
echo 'Cпособности Last Chanse Thick Fat' > munchlax
echo 'Тип покемона NORMAL FLYING' > doduo
echo -e 'Способности\nHypnosis Imprison Confuse Ray Psywave Iron Defense Faint Attack\nSafeguard Future Sighr Metal Sound Block Gyro Ball Extrasensory\nPayback Heal Block Heavy Slam' > bronzong
cd ..

echo -e 'Развитые способности\nStench' > gloom1

cd onix2
echo 'Живет Cave Mountain' > clefable
echo -e 'satk=8 sdef=14\nspd6' > blissey
echo -e 'Способности Dark Art Intimidate Quick\nFeet' > mightyena
cd ..

echo 'Развитые способности Damp' > seadra8
echo -e 'Ходы Bug Bite\nFurry Cutter Giga Drain Mud-Slap Natural Gift Ominous Wind Sleep Talk\nSnore Spite String Shot Sucker Punch Swift Trick' > shedinja3
cd ..

#2
chmod a-rwx eevee5
chmod u+rx eevee5
chmod g+x eevee5
chmod o+wx eevee5
cd eevee5
chmod 357 archen
chmod 404 misdreavus
chmod 046 deerling
chmod 440 growlithe
chmod 400 pidove
cd ..

chmod 543 excadrill0
chmod 755 simipour
chmod 577 azurill
chmod 576 swinub
chmod 600 munchlax
chmod 444 doduo
chmod 444 bronzong
cd ..

chmod 644 gloom1

chmod 734 onix2
cd onix2
chmod 046 clefable
chmod 604 blissey
chmod 600 mightyetna
cd ..

chmod 062 seadra8
chmod 600 shednija3

#3
touch errors
ln -s shedinja3 eevee5/pidovesheninja 2> errors
ln -s eevee5 Copy_71 2>> errors
cp -r onix2 excadrill0/simipour 2>> errors
cat eevee5/deerling eevee5/misdreavus > shedinja3_13
cp seadra8 excadrill0/simipour 2>> errors
ln shedinja3 onix2/clefableshedinja 2>> errors

cat errors
#ln: eevee5/pidovesheninja: Permission denied
#cp: onix2/clefable: Permission denied
#cat: eevee5/deerling: Permission denied
#cp: seadra8: Permission denied

# изменим права доступа для выполнения задания, после чего вернем их обратно:
chmod u+x eevee5
ln -s shedinja3 eevee5/pidoveshedinja
chmod u-x eevee5

cd onix2
chmod u+r clefable
cp -r onix2 excadrill0/simipour
chmod u-r clefable
cd ..

cd eevee5
chmod u+r deerling
cat eevee5/deerling eevee5/misdreavus > shedinja3_13
chmod u-r deerling
cd ..

chmod u+r seadra8
cp seadra8 excadrill0/simipour
chmod u-r seadra8

rm errors

# 4
# посчитать все символы в файлах, найчинающихся на букву а. у меня таких файлов нет, но вот как бы это выглядело:
wc -m 2>/dev/null $(ls -pd a* */a* */*/a* */*/*/a* | grep -v "/$") > /tmp

# найти все файлы в котоых есть стока Do и вывести первые 4 в порядке убываения размера:
ls -l $(grep -l "Do" 2>/dev/null $(ls -pd * */* */*/* */*/*/* | grep -v "/$")) | head -4 | sort -k 5 -rn

# из директории excadrill0 ввывести с нумерацией все строки, оканчивающиеся на p
cd excadrill0
cat -b * 2>/dev/null| grep "p$"
cd ..

# вывести все атрибуты и имена файлов в директории eevee5, список отсортировать в порядке возрастания количества жестких ссылок, добавить вывод ошибок доступа в стандартный поток вывода
cd eevee5
ls -l 2>&1| grep "^-" |sort -k2 -nr
cd ..

# подсчитать количество строк в файле gloom1, результат записать в тот же файл
wc -l gloom1 >> gloom1

# Вывести три первых элемента рекурсивного списка имен и атрибутов файлов в директории lab0, содержащих строку "ve", список отсортировать по возрастанию даты доступа к файлу, ошибки доступа не подавлять и не перенаправлять

ls -l $(grep -li "ve" $(ls -pd * */* */*/* */*/*/* | grep -v "/$")) | head -3 |sort -k 6

# 5 удаление файлов
rm -f gloom1
rm -f excadrill0/bronzong
rm -f eevee5/pidoveshedin* 
# rm: eevee5/pidoveshedinja: Недостаточно привилегий

rm -f onix2/clefableshedin*
rm -fr eevee5
# rm: eevee5/misdreavus: Недостаточно привилегий
# rm: eevee5/archen: Недостаточно привилегий
# rm: eevee5/growlithe: Недостаточно привилегий
# rm: eevee5/deerling: Недостаточно привилегий
# rm: eevee5/spearow: Недостаточно привилегий
# rm: eevee5/pidovesheninja: Недостаточно привилегий
# rm: eevee5/pidove: Недостаточно привилегий
# rm: eevee5: Каталог не пуст

rmdir eevee5/archen
# rmdir: eevee5/archen: Permission denied
