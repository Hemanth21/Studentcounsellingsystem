import java.io.*;
import java.util.Scanner;

interface Studentinterface{
abstract int authentication()throws Exception;
void changepass()throws Exception;
}



class Student implements Studentinterface{


String pass;
String newpass;
String currentpass;


public int authentication()throws Exception {

File file=new File("password.txt");
Scanner input=new Scanner(file);
Scanner in=new Scanner(System.in);


System.out.print("Enter Admin Password:");
pass=in.next();
while(input.hasNext()) {
currentpass=input.next();
}
if(pass.equals(currentpass))
return 1;
else
return 0;
}



public void changepass()throws Exception {
String npass,cpass;
BufferedWriter output=null;
Scanner in=new Scanner(System.in);
File file=new File("password.txt");
Scanner input=new Scanner(file);
while(input.hasNext()) {
currentpass=input.next();
}
output=new BufferedWriter(new FileWriter("password.txt"));

System.out.print("Enter Current Password: ");
cpass=in.next();
if(cpass.equals(currentpass)){


System.out.print("Enter new password : ");
npass=in.next();
output.write(npass);
output.close();

System.out.println("  ");
System.out.println("Password Successfully changed for Admin Panel.");
}else{

System.out.println("  ");
System.out.println(" Incorrect Password.");
}
}

static void display(double p)throws Exception {
try{
System.out.println("   ");
File file=new File("file.txt");
String n1,n2,n3;
int dseats;

Scanner input=new Scanner(file);
System.out.println(" College Code"+"  .  "+"College Name"+"  .  "+"Available Seats ");
System.out.println("=================================================================");
while(input.hasNext()) {
n1=input.next();
n2=input.next();
n3=input.next();
dseats=Integer.parseInt(n3);
if(dseats>=0) {


System.out.printf("   "+" %-15s %-20s %-20s %n",n1,n2,n3);
}
}
input.close();
}catch(FileNotFoundException fnf) {
 System.out.println(fnf);
 System.out.println("File Not Found.");
}
}




static void decrementer() throws IOException {
Scanner in=new Scanner(System.in);
BufferedWriter output=null;
File record=new File("sturecords.txt");
if(!record.exists()) {
record.createNewFile();
}
output=new BufferedWriter(new FileWriter("sturecords.txt",true));

System.out.println("  ");
System.out.print("Enter Your Token Number : ");
String token=in.nextLine();
System.out.print("Enter Your Name (Caps)  : ");
String name=in.nextLine();
System.out.print("Enter Code of Selected College :");
String id=in.nextLine();

File originalFile = new File("file.txt");
BufferedReader br = new BufferedReader(new FileReader(originalFile));
File tempFile = new File("tempfile.txt");
PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

String line=null;
while((line=br.readLine()) !=null) {

if(line.contains(id)) {
String currentseats = line.substring(line.lastIndexOf(" "),line.length());
int tseats = Integer.parseInt(currentseats.trim());
if(tseats>0) {
if(currentseats !=null || !currentseats.trim().isEmpty()) {

int newseats=tseats-1;
System.out.println("  ");
System.out.println("You have Registered your seat successfully .");
line=line.substring(0,line.lastIndexOf(" "))+"  "+newseats;
if(token!=null){
output.write(token);
output.write(" ");

output.write(name);
output.write(" ");

output.write(id);
output.write(" ");
output.newLine();
output.close();
}}
}else{

System.out.println("  ");
System.out.println("The selected college is Invalid or out of stock.");
}

}
pw.println(line);
pw.flush();
}
pw.close();
br.close();

if(!originalFile.delete()) {

System.out.println("  ");
 System.out.println("Error Deleting File.........");
 return;
 }

if(!tempFile.renameTo(originalFile)) {

System.out.println("  ");
System.out.println("Error renaming File");
}
}
}


class Studentc extends Student {


static void updater() throws IOException {
Scanner in=new Scanner(System.in);

System.out.println("  ");
System.out.print("Enter College Code to Update Seats : ");
String id=in.nextLine();
System.out.print("Enter the number of seats to be increased (or) decreased : ");
int irdseats=in.nextInt();
System.out.println("  ");

File originalFile = new File("file.txt");
BufferedReader br = new BufferedReader(new FileReader(originalFile));
File tempFile = new File("tempfile.txt");
PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

String line=null;
while((line=br.readLine()) !=null) {

if(line.contains(id)) {
String currentseats2 = line.substring(line.lastIndexOf(" "),line.length());
int tseats2 = Integer.parseInt(currentseats2.trim());
if(tseats2>0 && (tseats2+irdseats)>=0) {
if(currentseats2 !=null || !currentseats2.trim().isEmpty()) {

int newseats=tseats2+irdseats;
System.out.println("  ");
System.out.println("Seats after updation  :"+newseats);
line=line.substring(0,line.lastIndexOf(" "))+"  "+newseats;

}
}else{

System.out.println("  ");
System.out.println("Unable to process the request (or) Invalid Updation. ");
}

}
pw.println(line);
pw.flush();
}
pw.close();
br.close();

if(!originalFile.delete()) {

System.out.println("  ");
 System.out.println("Error Deleting File.........");
 return;
 }

if(!tempFile.renameTo(originalFile)) {

System.out.println("  ");
System.out.println("Error renaming File..........");
}
}





static void admin()throws Exception{
BufferedWriter output=null;
File file = new File("file.txt");
if(!file.exists()){
   file.createNewFile();
 }

Scanner in=new Scanner(System.in);

output=new BufferedWriter(new FileWriter("file.txt", true));
System.out.print("Enter How many records:");
int n=in.nextInt();
for (int i=0;i<n;i++){

System.out.println("  ");
System.out.print("Enter College Code :");
String acode=in.next();
System.out.print("Enter College Name :");
String aname=in.next();
System.out.print("Enter No of seats  :");
String aseats=in.next();
System.out.println("  ");

output.write(acode);
output.write(" ");
output.write(aname);
output.write(" ");
output.write(aseats);
output.newLine();
}
output.close();
}



static void display(int q)throws Exception {
try{
System.out.println("   ");
File file=new File("file.txt");
String n1,n2,n3;
int dseats;

Scanner input=new Scanner(file);
System.out.println(" College Code"+"  .  "+"College Name"+"  .  "+"Available Seats ");
System.out.println("=================================================================");
while(input.hasNext()) {
n1=input.next();
n2=input.next();
n3=input.next();
dseats=Integer.parseInt(n3);
if(dseats>0) {

System.out.printf("   "+" %-15s %-20s %-20s %n",n1,n2,n3);
}
}
input.close();
}catch(FileNotFoundException fnf) {
 System.out.println(fnf);

 System.out.println("  ");
 System.out.println("File Not Found.");
}
}



static void searchstudent()throws Exception{

try{
File file = new File("sturecords.txt");
int fnd=0;
Scanner in=new Scanner(System.in);

System.out.print("Enter Student token number: ");
int stoken=in.nextInt();

Scanner input=new Scanner(file);
while(input.hasNext()) {
String stoken1=input.next();
String sname=input.next();
String sid=input.next();
int iid=Integer.parseInt(stoken1);

if(stoken==iid){
System.out.println("                    ");
System.out.println("  "+stoken1+ "   "+sname+ "   "+sid );
fnd=1;
break;
}
}

if(fnd==0)
System.out.println(" No Student Found with given token number.");
}catch(Exception ioe){
  System.out.println(ioe);

System.out.println("  ");
  System.out.println(" File not found ");

}
}





public static void main(String args[])throws Exception{                               
int h=1,ca=1;

Studentc obj=new Studentc();                                                                             
Student s1;
s1=obj;

while(h!=0){
int ch;
Scanner in=new Scanner(System.in);
System.out.println("  ");
System.out.println(" Welcome to 2016 JEE Counselling");
System.out.println("  ");
System.out.println(" 1. Student");
System.out.println(" 2. Admin");
System.out.println(" 3. Exit "  );
System.out.println("  ");
System.out.print (" Enter your choice :");
ch=in.nextInt();
System.out.println("  ");
switch(ch){
case 1:{
display(1);
System.out.println(" ");
System.out.println(" ");
decrementer();
break;
}

case 2: {
int check;
check=s1.authentication();                                                        
while(ca!=0){
if(check==1){
display(1.1);
System.out.println("  ");
System.out.println("1.Enter new data");
System.out.println("2.Modify Existng data");
System.out.println("3.Search Records");
System.out.println("4.Change password");
System.out.println("5.Exit Admin Panel");
System.out.println("  ");
System.out.print("Enter your choice: ");

ca=in.nextInt();
System.out.println("  ");
switch(ca){

case 1: {
admin();
break;
}

case 2: {
updater();
break;
}

case 3: {
searchstudent();
break;
}

case 4: {
s1.changepass();
break;
}

case 5: {
ca=0;
break;
}


default: System.out.println(" Invalid Selection. ");
System.out.println(" ");
break;
}
} else if(check==0) {
System.out.println("  ");
System.out.println("Incorrect password");
break;
}
}
ca=1;
break;
}
case 3: {
h=0;
break;
}


default: System.out.println("Invalid Selection.");
}
}
}
}












































