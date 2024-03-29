package willywank.mainobjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Map {
    public final int size;
    public Cell[][] cells;

    public Map() {
        this.size = 10;
        this.cells = new Cell[this.size][this.size];
    }

    public Map(int size) {
        this.size = size;
        this.cells = new Cell[this.size][this.size];
    }

    public void setCell(Cell c, int x, int y) {
        this.cells[x][y] = c;
    }

    public void generateMapFromFile() throws FileNotFoundException, IOException {
        File file = new File(System.getProperty("user.dir")+"/src/willywank/mainobjects/Map.txt");
        FileReader fr = new FileReader(file);
        int c;
        int i = 0, j = 0;
        while ((c = fr.read()) != -1) {
            char ch = (char) c;
            if (ch == '\n') {
                i++;
                j = 0;
            } else if (ch == 'o') {
                this.cells[i][j] = new Cell("Sea");
                j++;
            } else if (ch == '-') {
                this.cells[i][j] = new Cell("Grassland");
                j++;
            } else if (ch == '^') {
                this.cells[i][j] = new Cell("Mountains");
                j++;
            } else if (ch == 'v') {
                this.cells[i][j] = new Cell("Tundra");
                j++;
            }
        }
        fr.close();
    }

    public void generateMap() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (i <= 2 || i >= 8 || j <= 2 || j >= 8){
                    this.cells[i][j] = new Cell("Sea");
                }
                else{
                    this.cells[i][j] = new Cell("Grassland");
                }
            }
        }
    }

    public Cell getCell(int x, int y) {
        if ((x >= 0 && x < this.size) && (y >= 0 || y < this.size)) {
            return this.cells[x][y];
        } else {
            return null;
        }
    }

    public void printMap(Player P) {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {

                if (P.getPosX() == i && P.getPosY() == j){
                    this.cells[i][j].printSymbol(1);

                } else if (P.ActiveX() == i && P.ActiveY() == j) {
                    this.cells[i][j].printSymbol(2);

                } else if (this.cells[i][j].isOccupied()) {
                    if (this.cells[i][j].getEnemy().getPosX() == i && this.cells[i][j].getEnemy().getPosY() == j) {
                        this.cells[i][j].printSymbol(3);
                    }

                } else {
                    this.cells[i][j].printSymbol(4);
                }
            }
            System.out.println();
        }
    }
}
