SRC_DIR=src
MAIN_DIR=$(SRC_DIR)/main
MAIN_CLASS=MainClass
ARGS=20 C

all: compile run

compile:
	@javac $(SRC_DIR)/**/*.java

run:
	@java -cp $(SRC_DIR) main.$(MAIN_CLASS) $(ARGS)

clean:
	@rm -f $(SRC_DIR)/**/*.class