//package Applets;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.awt.image.*;
import java.util.*;
import java.text.DateFormat;
import java.awt.MediaTracker;

public class MyApp extends Applet implements ActionListener,Runnable
{
	Thread thisThread;	
	Button MyButton,Bpos,Bstop;
	int Width,Height;
	int MajorAxis,MinorAxis;
	int xOffset,yOffset;

	DateFormat Frmt;	
	Planet Earth,Mars,Venus,Moon;
	Image mImage;
	Image ImgEarth,ImgSun,ImgMars,ImgVenus,ImgMoon;
	Image ImgFullMoon,ImgHalfMoon,ImgQuarterMoon;
	Choice CDay,CMonth,CYear;
	Calendar	cal;
	Panel P1;
	MediaTracker tracker;
	public  int flag;
 
 
	public void init()
	{
		flag =0;
		Width =753;
		Height =355;

		setBackground(Color.black);
		tracker = new MediaTracker(this);

		MyButton = new Button("Run Simulator");
		Bpos = new Button("Show Position");
		Bstop = new Button("Stop Simulator");

		this.setLayout(null);
		MyButton.setBounds(Width-120,Height-75,100,25);
		Bpos.setBounds(Width-230,Height-75,100,25);
		Bstop.setBounds(Width-230,Height-40,210,25);
		
		add(MyButton);
		add(Bpos);
		add(Bstop);
		Bpos.addActionListener(this);
		MyButton.addActionListener(this);
		Bstop.addActionListener(this);

		
		ImgEarth =getImage(getCodeBase(),"earth.jpg"); 
		tracker.addImage(ImgEarth, 0);
		ImgMars =getImage(getCodeBase(),"Mars.jpg"); 
		tracker.addImage(ImgMars,1);
		ImgSun =getImage(getCodeBase(),"sun9.gif");
		tracker.addImage(ImgSun,2);
		ImgVenus =getImage(getCodeBase(),"Venus.jpg");
		tracker.addImage(ImgVenus,3);
		ImgMoon =getImage(getCodeBase(),"Moon.jpg");
		tracker.addImage(ImgMoon,4);
		ImgFullMoon =getImage(getCodeBase(),"FullMoon.jpg");
		ImgHalfMoon =getImage(getCodeBase(),"firstquart.jpg");
		ImgQuarterMoon =getImage(getCodeBase(),"firstquart++.jpg");

		CDay =new Choice();
		CMonth = new Choice();
		CYear =new Choice();
		P1 = new Panel();
		P1.setBackground(Color.gray);
	
		
		for(int i=1;i<=31;i++)
		{
			CDay.addItem(String.valueOf(i));
		}
		P1.add(CDay);
		for(int i=1;i<=12;i++)
		{
			CMonth.addItem(String.valueOf(i));
		}
		P1.add(CMonth);
		for(int i=1900;i<=2100;i++)
		{
			CYear.addItem(String.valueOf(i));
		}
		P1.add(CYear);
		CDay.select("4");
		CMonth.select("1");	
		CYear.select("2001");
		P1.setBounds(Width-200,40,180,35);
		add(P1);
		P1.show();
		cal = new GregorianCalendar();
		cal.set(Calendar.YEAR,Integer.parseInt(CYear.getSelectedItem()));
		cal.set(Calendar.MONTH,Integer.parseInt(CMonth.getSelectedItem())-1);
		cal.set(Calendar.DATE,Integer.parseInt(CDay.getSelectedItem()));
		
		// Settings For Earth
		
			

		Earth =new Planet();

		MajorAxis =(Width/4+150)/2;
		MinorAxis =(Height/4+10)/2+5;
		
		Earth.setAxis(MajorAxis,MinorAxis,(float)0.9863,(float)368.3472);		
		
		Earth.setAngle((float)Integer.parseInt(CYear.getSelectedItem()),
					(float)Integer.parseInt(CMonth.getSelectedItem()),
					(float)Integer.parseInt(CDay.getSelectedItem()));
		
		
		MajorAxis =(Width/4+150)/2;
		MinorAxis =(Height/4+10)/2;
		
		Mars =new Planet();

		MajorAxis +=20;
		MinorAxis +=20;
		Mars.setAxis(MajorAxis,MinorAxis,(float)0.5240324,(float)650.034721);		
		Mars.setAngle((float)Integer.parseInt(CYear.getSelectedItem()),
					(float)Integer.parseInt(CMonth.getSelectedItem()),
					(float)Integer.parseInt(CDay.getSelectedItem()));
		
	

		Venus =new Planet();
		
		MajorAxis -=40;
		MinorAxis -=30;
		
		Venus.setAxis(MajorAxis,MinorAxis,(float)1.6021315,(float)416.756944);		
		
		Venus.setAngle((float)Integer.parseInt(CYear.getSelectedItem()),
					(float)Integer.parseInt(CMonth.getSelectedItem()),
					(float)Integer.parseInt(CDay.getSelectedItem()));
							
	
		Moon =new Planet();
		
		MajorAxis =(Height/4+10)/2+5;
		MinorAxis =(Height/4+10)/2;
		
		Moon.setAxis(MajorAxis,MinorAxis,(float)12.10366934,(float)373.347221);	//12.3193916	
		
		Moon.setAngle((float)Integer.parseInt(CYear.getSelectedItem()),
					(float)Integer.parseInt(CMonth.getSelectedItem()),
					(float)Integer.parseInt(CDay.getSelectedItem()));
		
		
		
			
		try{
		tracker.waitForAll();	}
		catch(Exception e4){ };
		thisThread =  new Thread(this);
		thisThread.start();
		thisThread.suspend();
		

	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==MyButton)  // Run simulator
		{	
		
			if(flag==0)
			{
		
 			/* Venus.setAngle((float)Integer.parseInt(CYear.getSelectedItem()),
					(float)Integer.parseInt(CMonth.getSelectedItem()),
					(float)Integer.parseInt(CDay.getSelectedItem()));
		
			Earth.setAngle((float)Integer.parseInt(CYear.getSelectedItem()),
					(float)Integer.parseInt(CMonth.getSelectedItem()),
					(float)Integer.parseInt(CDay.getSelectedItem()));
		
			Mars.setAngle((float)Integer.parseInt(CYear.getSelectedItem()),
					(float)Integer.parseInt(CMonth.getSelectedItem()),
					(float)Integer.parseInt(CDay.getSelectedItem()));
		
			Moon.setAngle((float)Integer.parseInt(CYear.getSelectedItem()),
					(float)Integer.parseInt(CMonth.getSelectedItem()),
					(float)Integer.parseInt(CDay.getSelectedItem()));
			*/	
		
			   thisThread.resume();
			   
				flag =1;	
			}

			
		}
		if(e.getSource()==Bpos)
		{	
		 
	     Venus.setAngle((float)Integer.parseInt(CYear.getSelectedItem()),
					(float)Integer.parseInt(CMonth.getSelectedItem()),
					(float)Integer.parseInt(CDay.getSelectedItem()));
		
		Earth.setAngle((float)Integer.parseInt(CYear.getSelectedItem()),
					(float)Integer.parseInt(CMonth.getSelectedItem()),
					(float)Integer.parseInt(CDay.getSelectedItem()));
		
		Mars.setAngle((float)Integer.parseInt(CYear.getSelectedItem()),
					(float)Integer.parseInt(CMonth.getSelectedItem()),
					(float)Integer.parseInt(CDay.getSelectedItem()));
		
		Moon.setAngle((float)Integer.parseInt(CYear.getSelectedItem()),
					(float)Integer.parseInt(CMonth.getSelectedItem()),
					(float)Integer.parseInt(CDay.getSelectedItem()));
		
		cal.set(Calendar.YEAR,Integer.parseInt(CYear.getSelectedItem()));
		cal.set(Calendar.MONTH,Integer.parseInt(CMonth.getSelectedItem())-1);
		cal.set(Calendar.DATE,Integer.parseInt(CDay.getSelectedItem()));
		

		//update(this.getGraphics());			
		paint(this.getGraphics());			

		if (flag ==1)
		{
			try{
			thisThread.suspend();
				
			}
			catch(Exception e3) { };
			flag =0;
		}




		}
		if(e.getSource()==Bstop)
		{	
		
			if(flag==1)
			{	
			   thisThread.suspend();
			   
				flag =0;	
			}

			
		}
	
		
	}
	
	

	




	public void start()
	{
		
		//thisThread.suspend();
	}

	
	public void run()
	{
		

		while(true)
		{
			 Earth.IncrementAngle();
			 cal.add(Calendar.HOUR,24);
		 	 Mars.IncrementAngle();
			 Venus.IncrementAngle();
			 Moon.IncrementAngle();	
			 try{
			 thisThread.sleep(250);
			 }catch (Exception e){ };
    			 repaint();

		}

	}
	public void paint(Graphics g)
	{

		Dimension d= getSize();
		if(mImage==null ||
			mImage.getWidth(null) != d.width ||
			mImage.getHeight(null) != d.height)
			mImage =createImage(d.width,d.height);
	
		Graphics offG = mImage.getGraphics();
		offG.setColor(getBackground());
		offG.fillRect(0,0,d.width,d.height);
		paintOffscreen(mImage.getGraphics());
		g.drawImage(mImage,0,0,null);

	}
	public void paintOffscreen(Graphics g)
	{
		
	    int t= Width-Width/3;
	    String Phase = new String(" ");	
		g.setColor(Color.white);
		g.drawRect(20,40,t-20,Height-70); // Outer Rectagle
		g.drawString("Select a Date (dd/mm/yy)",Width-200,35) ;
		g.drawString("Position of Planets on ",40,Height-40);
		g.drawString(Frmt.getDateInstance().format(cal.getTime()),210,Height-40);
		
		
		g.drawImage(ImgVenus,410,Height-90,this);	
		g.drawString("Venus",450,Height-80);
		g.drawImage(ImgEarth,407,Height-72,this);	
		g.drawString("Earth",450,Height-60);
		g.drawImage(ImgMars,410,Height-50,this);	
		g.drawString("Mars",450,Height-40);

		// For Moons Rectangular Box

		g.drawImage(ImgSun,333,170,this);
		g.drawRect(t+20,Height-260,220,Height-200); //Inner Rectangle
		g.drawImage(ImgSun,t+210,Height-190,this);
		g.drawImage(ImgEarth,t+75,Height-190,this);
		
		
		
		
		
	while(true)
	{
		
		if(Moon.Angle >= 45 && Moon.Angle <= 135 )
		{
			Phase = "Last Quarter";
			g.drawImage(ImgHalfMoon,t+200,Height-140,this);
			break;

		
		}
		if(Moon.Angle >= 135 && Moon.Angle <= 225 )
		{
			Phase = "New  Moon";
			g.drawImage(ImgQuarterMoon,t+200,Height-140,this);
			break;

		
		}

		
		if(Moon.Angle >= 225 && Moon.Angle <= 315 )
		{
			Phase = "FirstQuarter";
			g.drawImage(ImgHalfMoon,t+200,Height-140,this);
			break;
		
		}
		if(Moon.Angle >= 315  )
		{
			Phase = "Full Moon";
			g.drawImage(ImgFullMoon,t+200,Height-140,this);
			break;
		
		}
		if(Moon.Angle <= 45  )
		{
			Phase = "Full Moon";
			g.drawImage(ImgFullMoon,t+200,Height-140,this);
			break;
		
		}
		
		
		
	}



 		g.drawString(Phase,t+30,Height-110);
		//g.drawString(Float.toString(Venus.Angle),t+30,Height-90);
		//g.drawString(Float.toString(Venus.dayno),t+110,Height-90);

		Moon.drawOrbit(t+30,Height-230,g);
		Moon.drawPlanet(g,ImgMoon);
		Mars.drawOrbit(60,110,g);
		Mars.drawPlanet(g,ImgMars);
		Earth.drawOrbit(80,120,g);
		Earth.drawPlanet(g,ImgEarth);
		Venus.drawOrbit(100,130,g);
		Venus.drawPlanet(g,ImgVenus);
		
		
	
	}
	public void update(Graphics g)
	{ paint(g); }



}

class Planet extends Applet
{
	int MajorAxisP;
	int MinorAxisP;
	int MajorAxisPSh;
	int	MinorAxisPSh;
	public float Angle;
	float dayno;
	float degPerYear;
	float daynoAtPer;
	int xOffset,yOffset;

	
	public Planet()
	{
	}
	
	public void setAxis(int Major,int Minor,float degPerYearP,float daynoAtPerP)
	{
		this.MajorAxisP =Major;
		this.MinorAxisP =Minor;
		this.MajorAxisPSh=MajorAxisP- 5;
		this.MinorAxisPSh=MinorAxisP-5;
		this.degPerYear =degPerYearP;
		this.daynoAtPer =daynoAtPerP;	
	}

	public void setAngle(float Year,float Month,float Date)
	{
	  dayno =367*Year -((7*(Year+((Month+9)/12)))/4) +
			((275*Month)/9) + Date -730530;
		
	 this.Angle =  degPerYear *(dayno -  daynoAtPer);
		while(this.Angle>360)
			 this.Angle-=360;
		//this.Angle-=2.90264;
	}		


	public void drawOrbit(int xOffset,int yOffset,Graphics g)
	{
		g.setColor(Color.white);
		g.drawOval(xOffset,yOffset,MajorAxisP*2,MinorAxisP*2); // Orbit
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	public void drawPlanet(Graphics g,Image Earth)
	{


		 xOffset = MajorAxisP + xOffset-5;
		 yOffset =MinorAxisP + yOffset-5;
		
		g.drawImage(Earth,(int)(MajorAxisP*Math.cos(toRadian(this.Angle))+xOffset),
		(int)(MinorAxisP*Math.sin(toRadian(this.Angle))+yOffset),Color.black,
		this);   //Earth
    

	}
	public void IncrementAngle()
	{
		this.Angle+=this.degPerYear;
		while(this.Angle>360)
			 this.Angle-=360;
			
	}
	public float toRadian(float deg)
	{
		float rad;
		rad  = (float)0.017453292 * deg;
		return rad;
	}


}


