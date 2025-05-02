# FlashCardB210910042
Программ хангамжийн бүтээлт бие даалт

java -cp target/demo-1.0-SNAPSHOT.jar my.flashcard.b210910042.Main cards.txt --order recent-mistakes-first --repetitions 3
worst-first
random
java -cp target/demo-1.0-SNAPSHOT.jar my.flashcard.b210910042.Main cards.txt --order worst-first --repetitions 3

java -cp target/demo-1.0-SNAPSHOT.jar my.flashcard.b210910042.Main cards.txt --order random --repetitions 3 --invertCards

java -cp target/demo-1.0-SNAPSHOT.jar my.flashcard.b210910042.Main --help
