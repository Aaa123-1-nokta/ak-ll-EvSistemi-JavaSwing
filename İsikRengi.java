package akillievsistemi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicButtonUI;

public class İsikRengi extends JFrame {
    private int akim;
    private float ısikSiddeti;
     public İsikRengi() {
                


          //IŞIK RENGİ İÇİN FRAME OLUŞTURDU
        JFrame isikRengiFrame=new JFrame("IŞIK RENGİ");
        isikRengiFrame.setSize(370, 679);
        isikRengiFrame.setLocationRelativeTo(null); // Pencereyi sayfanın ortasında aç
        isikRengiFrame.setLayout(null);
        isikRengiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        isikRengiFrame.getContentPane().setBackground(Color.WHITE);
        
        
         //geri butonu için
        JButton geri=new JButton("");
        geri.setBounds(10, 70, 30, 30);
        geri.setBackground(new Color(255,255,255)); // Pastel kırmızı-pembe renk
        ImageIcon geriaydin = resizeImage("src/akillievsistemi/aydinlatmaresimler/gerii.png", 30,30); // Resmi 30x30 boyutlandır
        geri.setIcon(geriaydin);
        geri.setForeground(new Color(0,0,0,140));
        geri.setOpaque(false); // Butonun arka planını görünür kıl
        geri.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır.
        geri.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 10000, 10000); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        //isikRengiFrame.add(geri); // Aydınlatma butonunu panele ekle
        //geri butonuna basıldığında
       // geri.addActionListener(new ActionListener() {
         //   public void actionPerformed(ActionEvent e) {
              // new  MutfakAydınlatma1((float) 4.0,6);
           // }
        //}); 
        
        //kısayol tuşları için
        JLabel label3 = new JLabel();
        label3.setBounds(-5, 433, 390, 400); // kısayol tuşları ve konumu
        ImageIcon kı = resizeImage("src/akillievsistemi/aydinlatmaresimler/kısayol2.png", 380, 38); // 200x200 boyutunda resmi ayarla
        label3.setIcon(kı);
        isikRengiFrame.add(label3); // JLabel'i panele ekle
        
        JLabel labelrenk = new JLabel();
        labelrenk.setBounds(55, -50, 400, 400); // ana resmin konumu ve boyutu
        ImageIcon renkmut = resizeImage("src/akillievsistemi/aydinlatmaresimler/renkpaleti.png", 250, 200); // 300*300 boyutunda resmi ayarla
        labelrenk.setIcon(renkmut);
        isikRengiFrame.add(labelrenk); // JLabel'i panele ekle 
        
        
        //saat ve sarj göstergesi
        JLabel labelmu = new JLabel();
        labelmu.setBounds(0, -340, 390, 710); // saat konumu ve boyutu
        ImageIcon resim2 = resizeImage("src/akillievsistemi/aydinlatmaresimler/saat.png", 370, 36); // 200x200 boyutunda resmi ayarla
        labelmu.setIcon(resim2);
        isikRengiFrame.add(labelmu);
        
        
       //yazı ekleme
        JLabel label1 = new JLabel("Lütfen renk seçiniz");
        label1.setBounds(75, 120, 300, 300); // Yazının konumu ve boyutu
        label1.setForeground(Color.BLACK);
        Font yazisekli = new Font("Courier New", Font.PLAIN, 20); // Düz Courier New fontu
        label1.setFont(yazisekli);
        isikRengiFrame.add(label1);
        
        //yeşil aydınlatma için
        JButton yesil = new JButton("Yeşil");
        yesil.setBounds(27, 285, 135, 100);
        yesil.setBackground(new Color(75,75,75)); // Pastel ri
        ImageIcon yesilicon = resizeImage("src/akillievsistemi/aydinlatmaresimler/yeşil.png", 70, 70); // Resmi 70*70 boyutlandır
        yesil.setIcon(yesilicon);
        Font yesilfont = new Font("ARIAL", Font.ITALIC, 20);
        yesil.setFont(yesilfont);
        yesil.setOpaque(false); // Butonun arka planını görünür kıl
        yesil.setForeground(new Color(32,187,11));
        yesil.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        yesil.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        yesil.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        yesil.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        yesil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aydınlatmanız ' YEŞİL ' olarak ayarlanmıştır.");
                
            }
        });
        isikRengiFrame.add(yesil);
        
        
        //pembe aydınlatma için
        JButton pembe = new JButton("Pembe");
        pembe.setBounds(205, 285, 135, 100);
        pembe.setBackground(new Color(75,75,75)); // Pastel ri
        ImageIcon pembeicon = resizeImage("src/akillievsistemi/aydinlatmaresimler/pembe.png", 70, 70); // Resmi 70*70 boyutlandır
        pembe.setIcon(pembeicon);
        Font pembefont = new Font("ARIAL", Font.ITALIC, 20);
        pembe.setFont(pembefont);
        pembe.setOpaque(false); // Butonun arka planını görünür kıl
        pembe.setForeground(new Color(255,0,198));
        pembe.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        pembe.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        pembe.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        pembe.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        pembe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aydınlatmanız ' Pembe ' olarak ayarlanmıştır.");
                
            }
        });
        isikRengiFrame.add(pembe);
        
        
        //mavi aydınlatma için
        JButton mavi = new JButton("Mavi");
        mavi.setBounds(205, 395, 135, 100);
        mavi.setBackground(new Color(75,75,75)); // Pastel gri
        ImageIcon maviicon = resizeImage("src/akillievsistemi/aydinlatmaresimler/mavi.png", 70, 70); // Resmi 70*70 boyutlandır
        mavi.setIcon(maviicon);
        Font mavifont = new Font("ARIAL", Font.ITALIC, 20);
        mavi.setFont(mavifont);
        mavi.setOpaque(false); // Butonun arka planını görünür kıl
        mavi.setForeground(new Color(0,0,255));
        mavi.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        mavi.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        mavi.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        mavi.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        mavi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aydınlatmanız ' Mavi ' olarak ayarlanmıştır.");
                
            }
        });
        isikRengiFrame.add(mavi);
        
        
        //turuncu aydınlatma için
        JButton turuncu = new JButton("Turuncu");
        turuncu.setBounds(27, 395, 135, 100);
        turuncu.setBackground(new Color(75,75,75)); // Pastel gri
        ImageIcon turuncuicon = resizeImage("src/akillievsistemi/aydinlatmaresimler/turuncu.png", 70, 70); // Resmi 70*70 boyutlandır
        turuncu.setIcon(turuncuicon);
        Font turuncufont = new Font("ARIAL", Font.ITALIC, 20);
        turuncu.setFont(turuncufont);
        turuncu.setOpaque(false); // Butonun arka planını görünür kıl
        turuncu.setForeground(new Color(255,205,0));
        turuncu.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        turuncu.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        turuncu.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        turuncu.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        turuncu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aydınlatmanız ' Turuncu ' olarak ayarlanmıştır.");
                
            }
        });
        isikRengiFrame.add(turuncu);
        
        
        //beyaz aydınlatma için
        JButton beyaz = new JButton("Beyaz");
        beyaz.setBounds(27, 505, 135, 100);
        beyaz.setBackground(new Color(75,75,75)); // Pastel gri
        ImageIcon beyazicon = resizeImage("src/akillievsistemi/aydinlatmaresimler/beyaz.png", 70, 70); // Resmi 70*70 boyutlandır
        beyaz.setIcon(beyazicon);
        Font beyazfont = new Font("ARIAL", Font.ITALIC, 20);
        beyaz.setFont(beyazfont);
        beyaz.setOpaque(false); // Butonun arka planını görünür kıl
        beyaz.setForeground(new Color(255,255,255));
        beyaz.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        beyaz.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        beyaz.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        beyaz.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        beyaz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aydınlatmanız ' Beyaz ' olarak ayarlanmıştır.");
                
            }
        });
        isikRengiFrame.add(beyaz);
        
        //kırmızı aydınlatma için
        JButton kırmızı = new JButton("Kırmızı");
        kırmızı.setBounds(205, 505, 135, 100);
        kırmızı.setBackground(new Color(75,75,75)); // Pastel gri
        ImageIcon kırmızıicon = resizeImage("src/akillievsistemi/aydinlatmaresimler/kırmızı.png", 70, 70); // Resmi 70*70 boyutlandır
        kırmızı.setIcon(kırmızıicon);
        Font kırmızıfont = new Font("ARIAL", Font.ITALIC, 20);
        kırmızı.setFont(kırmızıfont);
        kırmızı.setOpaque(false); // Butonun arka planını görünür kıl
        kırmızı.setForeground(new Color(255,0,0));
        kırmızı.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        kırmızı.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        kırmızı.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        kırmızı.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        kırmızı.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aydınlatmanız ' Kırmızı ' olarak ayarlanmıştır.");
                
            }
        });
        isikRengiFrame.add(kırmızı);
        
        
        isikRengiFrame.setVisible(true);
    }
    
    private static ImageIcon resizeImage(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage(); // resmi al
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH); // yeni boyutlandır
        return new ImageIcon(newImg); // yeniden ImageIcon olarak döndür
    }
    
}
