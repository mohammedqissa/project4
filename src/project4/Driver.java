package project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class Driver extends Application{

	RadioButton bubble,insertion,radix,heap,merge,quick,shell,all;
	ComboBox<String> combo;
	Label[][] labels;
	RadioButton l1,l2,l3,l4,l5,l6;
	static File file1,file2,file3;
	Label bubbleL,insertionL,radixL,heapL,mergeL,quickL,shellL,sortType;





	public static void main(String[] args){
		
		file1 = new File("Sorted_File.txt");
		file2 = new File("Random_File.txt");
		file3 = new File("UnSorted_File.txt");

		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Stage window = primaryStage;



		labels = new Label[7][6];


		for (int i = 0; i < labels.length; i++) {
			for (int j = 0; j < labels[i].length; j++) {
				labels[i][j] = new Label("-");
				labels[i][j].setMinWidth(30);
			}
		}

		bubbleL = new Label("Bubble");
		insertionL = new Label("Insertion");
		radixL = new Label("Radix");
		heapL = new Label("Heap");
		mergeL = new Label("Merge");
		quickL = new Label("Quick");
		shellL = new Label("Shell");
		sortType = new Label("Sorted");




		l1 = new RadioButton("1000");
		l2 = new RadioButton("10000");
		l3 = new RadioButton("100000");
		l4 = new RadioButton("500000");
		l5 = new RadioButton("1000000");
		l6 = new RadioButton("2000000");



		GridPane grid = new GridPane();
		grid.setMinSize(400,200);
		grid.setVgap(10);
		grid.setHgap(10);

		for (int i = 0; i < labels.length; i++) {
			for (int j = 0; j < labels[i].length; j++) {
				grid.add(labels[i][j], j+1, i+1);

			}
		}

		grid.add(sortType, 0, 0);
		grid.add(l1, 1, 0);
		grid.add(l2, 2, 0);
		grid.add(l3, 3, 0);
		grid.add(l4, 4, 0);
		grid.add(l5, 5, 0);
		grid.add(l6, 6, 0);


		






		combo = new ComboBox<>();

		combo.getItems().addAll("Sorted","Random","Unsorted");
		combo.setValue("Sorted");
		


		bubble = new RadioButton("Bubble");
		insertion = new RadioButton("Insertion");
		radix = new RadioButton("Radix");
		heap = new RadioButton("Heap");
		merge = new RadioButton("Merge");
		quick = new RadioButton("Quick");
		shell = new RadioButton("Shell");
		all = new RadioButton("All");

		all.setOnAction(e -> {
			if(all.isSelected()){
				bubble.setSelected(true);
				insertion.setSelected(true);
				radix.setSelected(true);
				heap.setSelected(true);
				merge.setSelected(true);
				quick.setSelected(true);
				shell.setSelected(true);
			}
			else if(!all.isSelected()){
				bubble.setSelected(false);
				insertion.setSelected(false);
				radix.setSelected(false);
				heap.setSelected(false);
				merge.setSelected(false);
				quick.setSelected(false);
				shell.setSelected(false);
			}
			
		});

		bubble.setOnAction(e -> {
			if(!bubble.isSelected()){
				all.setSelected(false);
			}
			refresh();
		});

		insertion.setOnAction(e -> {
			if(!insertion.isSelected()){
				all.setSelected(false);
			}
			refresh();
		});
		radix.setOnAction(e -> {
			if(!radix.isSelected()){
				all.setSelected(false);
			}
			refresh();
		});
		heap.setOnAction(e -> {
			if(!heap.isSelected()){
				all.setSelected(false);
			}
			refresh();
		});
		merge.setOnAction(e -> {
			if(!merge.isSelected()){
				all.setSelected(false);
			}
			refresh();
		});
		quick.setOnAction(e -> {
			if(!quick.isSelected()){
				all.setSelected(false);
			}
			refresh();
		});
		shell.setOnAction(e -> {
			if(!shell.isSelected()){
				all.setSelected(false);
			}
			refresh();
		});


		
		grid.add(bubble, 0, 1);
		grid.add(insertion, 0, 2);
		grid.add(radix, 0, 3);
		grid.add(heap, 0, 4);
		grid.add(merge, 0, 5);
		grid.add(quick, 0, 6);
		grid.add(shell, 0, 7);
		grid.add(all, 0, 8);

		


		grid.setAlignment(Pos.CENTER);




		Button cal = new Button("Calculate time");
		Button exit = new Button("Exit");
		exit.setOnAction(e -> System.exit(0));
		cal.setOnAction(e -> calButtonClicked());


		combo.setOnAction(e -> {
			

			for (int i = 0; i < labels.length; i++) {
				for (int j = 0; j < labels[i].length; j++) {
					labels[i][j].setText("-");
				}
			}

			sortType.setText(combo.getValue());
			
		});
		
		
		Button save = new Button("Save");
		save.setOnAction(e -> save());




//		HBox hbox3 = new HBox();
//		hbox3.getChildren().addAll(bubble,insertion,radix,heap,merge,quick,shell,all);
//		hbox3.setSpacing(10);
//		hbox3.setAlignment(Pos.CENTER);


		HBox hbox4 = new HBox();
		hbox4.getChildren().addAll(cal,save,exit);
		hbox4.setAlignment(Pos.CENTER);
		hbox4.setSpacing(30);
		
		

		HBox hbox = new HBox();
		hbox.getChildren().addAll(new Label("Data is :"),combo);
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(5);

		VBox vbox = new VBox();
		vbox.getChildren().addAll(new Label("Sort Time Calculator"),grid,new Label(" "),hbox,hbox4,new Label(" "));
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(15);

		Scene scene = new Scene(vbox);
		window.setScene(scene);
		window.show();




	}

	private void save()  {

	String s = "";
	
	s+= sortType.getText()+" "+" 1000"+" 10000"+" 100000"+" 500000"+" 1000000"+" 2000000"+"\n";
	s+= bubble.getText() + " "+labels[0][1].getText()+" "+ " "+labels[0][2].getText()+" "+ " "+labels[0][3].getText()+" "+ " "+labels[0][4].getText()+" "+ " "+labels[0][5].getText()+" "+ "\n";
	s+= insertion.getText() + " "+labels[1][1].getText()+" "+ " "+labels[1][2].getText()+" "+ " "+labels[1][3].getText()+" "+ " "+labels[1][4].getText()+" "+ " "+labels[1][5].getText()+" "+ "\n";
	s+= radix.getText() + " "+labels[2][1].getText()+" "+ " "+labels[2][2].getText()+" "+ " "+labels[2][3].getText()+" "+ " "+labels[2][4].getText()+" "+ " "+labels[2][5].getText()+" "+ "\n";
	s+= heap.getText() + " "+labels[3][1].getText()+" "+ " "+labels[3][2].getText()+" "+ " "+labels[3][3].getText()+" "+ " "+labels[3][4].getText()+" "+ " "+labels[3][5].getText()+" "+ "\n";
	s+= merge.getText() + " "+labels[4][1].getText()+" "+ " "+labels[4][2].getText()+" "+ " "+labels[4][3].getText()+" "+ " "+labels[4][4].getText()+" "+ " "+labels[4][5].getText()+" "+ "\n";
	s+= quick.getText() + " "+labels[5][1].getText()+" "+ " "+labels[5][2].getText()+" "+ " "+labels[5][3].getText()+" "+ " "+labels[5][4].getText()+" "+ " "+labels[5][5].getText()+" "+ "\n";
	s+= shell.getText() + " "+labels[6][1].getText()+" "+ " "+labels[6][2].getText()+" "+ " "+labels[6][3].getText()+" "+ " "+labels[6][4].getText()+" "+ " "+labels[6][5].getText()+" "+ "\n";
	
	
	PrintWriter p = null;
	
	if(sortType.getText().equals("Sorted"))
		try {
			p = new PrintWriter(file1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	else if(sortType.getText().equals("Random"))
		try {
			p = new PrintWriter(file2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	else
		try {
			p = new PrintWriter(file3);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	p.print(s);
	p.close();
	
	
	}

	private void calButtonClicked() {



		if(l1.isSelected()){
			sort(1000,0);
		}
		if(l2.isSelected()){
			sort(10000,1);
		}
		if(l3.isSelected()){
			sort(100000,2);
		}
		if(l4.isSelected()){
			sort(500000,3);
		}
		if(l5.isSelected()){
			sort(1000000,4);
		}
		if(l6.isSelected()){
			sort(2000000,5);
		}





		





	}





	private void refresh() {
		if(bubble.isSelected() && insertion.isSelected() && radix.isSelected() && heap.isSelected() && merge.isSelected() && quick.isSelected() && shell.isSelected())	
			all.setSelected(true);
	}

	private int[] getRandom(int size){

		Random r = new Random();
		int[] test = new int[size];

		for (int i = 0; i < size; i++){
			test[i] = r.nextInt(Integer.MAX_VALUE);
		}
		return test;

	}
	private int[] getSorted(int size){

		int[] test = new int[size];

		for (int i = 0; i < size; i++){
			test[i] = i;
		}
		return test;

	}
	private int[] getReverse(int size){

		int[] test = new int[size];

		for (int i = 0; i < size; i++){
			test[i] = size-i;
		}
		return test;

	}

	private void sort(int size,int i){

		int[] array;


		if(combo.getValue().equals("Sorted"))
			array = getSorted(size);
		else if(combo.getValue().equals("Random"))
			array = getRandom(size);
		else
			array = getReverse(size);


		if(bubble.isSelected()){
			long start = System.currentTimeMillis();
			BubbleSort.sort(array);
			long end = System.currentTimeMillis();

			if(i==0)
				labels[0][0].setText((end-start)+"");
			else if(i == 1)
				labels[0][1].setText((end-start)+"");
			else if(i == 2)
				labels[0][2].setText((end-start)+"");
			else if(i == 3)
				labels[0][3].setText((end-start)+"");
			else if(i == 4)
				labels[0][4].setText((end-start)+"");
			else
				labels[0][5].setText((end-start)+"");


		}
		if(insertion.isSelected()){
			long start = System.currentTimeMillis();
			InsertionSort.sort(array);
			long end = System.currentTimeMillis();

			if(i==0)
				labels[1][0].setText((end-start)+"");
			else if(i == 1)
				labels[1][1].setText((end-start)+"");
			else if(i == 2)
				labels[1][2].setText((end-start)+"");
			else if(i == 3)
				labels[1][3].setText((end-start)+"");
			else if(i == 4)
				labels[1][4].setText((end-start)+"");
			else
				labels[1][5].setText((end-start)+"");



		}
		if(radix.isSelected()){
			long start = System.currentTimeMillis();
			RadixSort.sort(array);
			long end = System.currentTimeMillis();

			if(i==0)
				labels[2][0].setText((end-start)+"");
			else if(i == 1)
				labels[2][1].setText((end-start)+"");
			else if(i == 2)
				labels[2][2].setText((end-start)+"");
			else if(i == 3)
				labels[2][3].setText((end-start)+"");
			else if(i == 4)
				labels[2][4].setText((end-start)+"");
			else
				labels[2][5].setText((end-start)+"");

		}
		if(heap.isSelected()){
			long start = System.currentTimeMillis();
			HeapSort.sort(array);
			long end = System.currentTimeMillis();

			if(i==0)
				labels[3][0].setText((end-start)+"");
			else if(i == 1)
				labels[3][1].setText((end-start)+"");
			else if(i == 2)
				labels[3][2].setText((end-start)+"");
			else if(i == 3)
				labels[3][3].setText((end-start)+"");
			else if(i == 4)
				labels[3][4].setText((end-start)+"");
			else
				labels[3][5].setText((end-start)+"");


		}
		if(merge.isSelected()){
			long start = System.currentTimeMillis();
			MergeSort.sort(array);
			long end = System.currentTimeMillis();

			if(i==0)
				labels[4][0].setText((end-start)+"");
			else if(i == 1)
				labels[4][1].setText((end-start)+"");
			else if(i == 2)
				labels[4][2].setText((end-start)+"");
			else if(i == 3)
				labels[4][3].setText((end-start)+"");
			else if(i == 4)
				labels[4][4].setText((end-start)+"");
			else
				labels[4][5].setText((end-start)+"");

		}
		if(quick.isSelected()){
			long start = System.currentTimeMillis();
			QuickSort.sort(array);
			long end = System.currentTimeMillis();

			if(i==0)
				labels[5][0].setText((end-start)+"");
			else if(i == 1)
				labels[5][1].setText((end-start)+"");
			else if(i == 2)
				labels[5][2].setText((end-start)+"");
			else if(i == 3)
				labels[5][3].setText((end-start)+"");
			else if(i == 4)
				labels[5][4].setText((end-start)+"");
			else
				labels[5][5].setText((end-start)+"");


		}
		if(shell.isSelected()){
			long start = System.currentTimeMillis();
			ShellSort.sort(array);
			long end = System.currentTimeMillis();

			if(i==0)
				labels[6][0].setText((end-start)+"");
			else if(i == 1)
				labels[6][1].setText((end-start)+"");
			else if(i == 2)
				labels[6][2].setText((end-start)+"");
			else if(i == 3)
				labels[6][3].setText((end-start)+"");
			else if(i == 4)
				labels[6][4].setText((end-start)+"");
			else
				labels[6][5].setText((end-start)+"");




		}
	}
}