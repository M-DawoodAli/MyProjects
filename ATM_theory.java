import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class ATM_theory {
	static long balance;
	static String ps;
	static int j=-1;static int[] id=new int[100];static String[] name=new String[100];static int[] acc=new int[1000];
	static long[] bal=new long[1000];static int k=-1;
	static long[] balance1=new long[100];static Scanner scan=new Scanner(System.in);
	static Connection con=Connect.dbConnect();
	static void add()
	{  try {
		String q="insert into atm (account,name,balance)values(?,?,?)";
				PreparedStatement pst=con.prepareStatement(q);
		j=j+1;
System.out.print("enter the account no:");
		id[j]=scan.nextInt();
		pst.setInt(1, id[j]);
		System.out.println("enter the name");
	name[j]=scan.next();
	pst.setString(2, name[j]);
		System.out.print("enter the balance:");
		balance1[j]=scan.nextLong();
		pst.setLong(3, balance1[j]);
		System.out.println("Successfully added");
		pst.execute();
	}catch(Exception e)
	{System.out.println(e.getMessage());
	}
}
	static void display()
	{
		Connection con=Connect.dbConnect();
		String qy="select * from atm";
		try {
			PreparedStatement pst=con.prepareStatement(qy);
			ResultSet rs=pst.executeQuery();
			    System.out.print("account_no            name        balance\n");
			while(rs.next())
			{   k=k+1;
			   acc[k]=rs.getInt(1);bal[k]=rs.getLong(3);
				System.out.print(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3)+"\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		int n,n1=0,i,z,a;char v;long bal3;do {
		System.out.println("1-admin  2-customer");
		
		n=scan.nextInt();
		switch(n) {
		case 1:System.out.print("enter your password:");
			ps=scan.next();
			System.out.println("password is verified");do {
			System.out.println("a-add d-display_details");
			v=scan.next().charAt(0);
			switch(v)
			{
				case 'a':add();break;
				case 'd':display();break;
				
			}
			System.out.println("press 1 to continue");
			a=scan.nextInt();
			}while(a==1);break;
		case 2:System.out.println("enter your account no:");
		int ch=scan.nextInt();
		for(int i1=0;i1<=k;i1++)
		{
			if(acc[i1]==ch) {  n1=i1;bal3=bal[i1];System.out.println("enter amount to be credited");break;}else{System.out.println("verify account no");}}
			long cr=scan.nextLong();
			bal3=bal[n1]+cr;
			Connection con=Connect.dbConnect();
			String qw="update atm set balance=? where account=?";
			try {
				PreparedStatement pst=con.prepareStatement(qw);
				pst.setLong(1, bal3);
				pst.setInt(2, ch);
				pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	break;
		}
	System.out.print("enter o to continue");
	z=scan.nextInt();
		}while(z==0);
}
	}


