package akillievsistemi;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicButtonUI;
public class YatakGuvenlik extends GuvenlikAbstract {
    private boolean yanginAlarmi;
    private boolean kapiKilidi;
    private boolean cocukKilidi;
    private boolean gazKacagi;
   
    @Override
    public void sistemikapat() {
        JOptionPane.showMessageDialog(null, "Mutfak güvenlik sistemi kapanmıştır.\nHiç bir mutfak güvenlik\nsistemi açık değildir.");
    }

    @Override
    public void sistemiac() {
        JOptionPane.showMessageDialog(null, "Mutfak guvenlik sistemi açılmıştır.");
    }

    
    public YatakGuvenlik() {
        JFrame ss =new JFrame();
        
        JLabel labelmutfak = new JLabel();
        labelmutfak.setBounds(55, -50, 400, 400); // ana resmin konumu ve boyutu
        ImageIcon a = resizeImage("src/akillievsistemi/guvelikresim/mutfak.png", 280, 200); // 300*300 boyutunda resmi ayarla
        labelmutfak.setIcon(a);
        ss.add(labelmutfak); // JLabel'i panele ekle
        // Ana frame ayarları
        ss.setTitle("Mutfak Güvenliği");
        ss.setSize(370, 679);
        ss.setLocationRelativeTo(null); // Pencereyi ortala
        ss.setLayout(null);
        ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ss.getContentPane().setBackground(Color.WHITE);
        
        // Resim Label'ı
        JLabel labelmu = new JLabel();
        labelmu.setBounds(0, -340, 390, 710); // saat konumu ve boyutu
        ImageIcon resim2 = resizeImage("src/akillievsistemi/aydinlatmaresimler/saat.png", 370, 36); // 200x200 boyutunda resmi ayarla
        labelmu.setIcon(resim2);
        ss.add(labelmu); // JLabel'i panele ekle
        
        JLabel label3 = new JLabel();
        label3.setBounds(-5, 433, 390, 400); // saat konumu ve boyutu
        ImageIcon kı = resizeImage("src/akillievsistemi/aydinlatmaresimler/kısayol2.png", 380, 38); // 200x200 boyutunda resmi ayarla
        label3.setIcon(kı);
        ss.add(label3); // JLabel'i panele ekle
        
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
        ss.add(geri); // Aydınlatma butonunu panele ekle
        //geri butonuna basıldığında
        geri.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            // Mevcut Aydınlatma sınıfına git
                new GuvenlikUI();
            }
        }); 
        
        
        //yazı ekleme
        JLabel label1 = new JLabel("Lütfen işlem seçiniz");
        label1.setBounds(75, 120, 300, 300); // Yazının konumu ve boyutu
        label1.setForeground(Color.BLACK);
        Font yazisekli = new Font("Courier New", Font.PLAIN, 20); // Düz Courier New fontu

        label1.setFont(yazisekli);
        ss.add(label1); // JLabel'i pencereye ekle
    
        
        // Yangın alarmı
        JButton yanginalarmi = new JButton("Yangın Alarmı");
        yanginalarmi.setBounds(27, 285,135, 100);
        yanginalarmi.setBackground(new Color(169, 169, 169)); // Pastel ri
        ImageIcon icon = resizeImage("src/akillievsistemi/guvelikresim/yangın.png", 70, 70); // Resmi 70x70 boyutlandır
        yanginalarmi.setIcon(icon);
        Font yangin = new Font("ARIAL", Font.ITALIC, 15);
        yanginalarmi.setFont(yangin);
        yanginalarmi.setOpaque(false); // Butonun arka planını görünür kıl
        yanginalarmi.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        yanginalarmi.setForeground(new Color(0,0,0,140));
        yanginalarmi.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        yanginalarmi.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        yanginalarmi.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        ss.add(yanginalarmi);
        yanginalarmi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 YanginAlarmi();
            }
        });
        
        
        // Kapı kilidi butonu
        JButton kapikilidi = new JButton("Kapı Kilidi ");
        kapikilidi.setBounds(205, 395, 135, 100);
        kapikilidi.setBackground(new Color(76, 106, 146));
        ImageIcon kilit = resizeImage("src/akillievsistemi/guvelikresim/kapıı.png", 65, 65); // Resmi 65*65 boyutlandır
        kapikilidi.setIcon(kilit);
        Font butongece = new Font("ARIAL", Font.ITALIC, 15);
        kapikilidi.setFont(butongece);
        kapikilidi.setOpaque(false); // Butonun arka planını görünür kıl
        kapikilidi.setForeground(new Color(0,0,0,140));
        kapikilidi.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        kapikilidi.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        kapikilidi.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        kapikilidi.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        ss.add(kapikilidi);
       
        
        kapikilidi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kapiKilidi();
            }
        });
        
        
        //gazkaçağı butonu için
        JButton gazButonu= new JButton("Gaz Kaçağı");
        gazButonu.setBounds(27, 395, 135, 100);
        gazButonu.setBackground(new Color(255, 179, 217)); // Pastel gri
        ImageIcon gaz = resizeImage("src/akillievsistemi/guvelikresim/gaz.png", 75, 75); // Resmi 65*65 boyutlandır
        gazButonu.setIcon(gaz);
        Font yemek23 = new Font("ARIAL", Font.ITALIC, 15);
        gazButonu.setFont(yemek23);
        gazButonu.setOpaque(false); // Butonun arka planını görünür kıl
        gazButonu.setForeground(new Color(0,0,0,140));
        gazButonu.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        gazButonu.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        gazButonu.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        gazButonu.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });

        gazButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gazKacagi();
            }
        }); 
        
        ss.add(gazButonu);

        
        //ac butonu
        JButton ac = new JButton("Sistemi Aç");
        ac.setBounds(27, 505, 135, 100);
        ac.setBackground(new Color(119, 221, 119)); // Pastel ri
        ImageIcon lambaac = resizeImage("src/akillievsistemi/guvelikresim/aç.png", 65, 65); // Resmi 65*65 boyutlandır
        ac.setIcon(lambaac);
        Font acfont = new Font("ARIAL", Font.ITALIC, 15);
        ac.setFont(acfont);
        ac.setOpaque(false); // Butonun arka planını görünür kıl
        ac.setForeground(new Color(0,0,0,140));
        ac.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        ac.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        ac.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        ac.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        ss.add(ac);
        ac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sistemiac();
            }
        });
       
        
        //yemek modu
        
        //kapat butonu
        JButton kapat = new JButton("Sistemi kapat");
        kapat.setBounds(205,505,135, 100);
        kapat.setBackground(new Color( 255, 105, 97)); // Pastel ri
        ImageIcon lambakapat= resizeImage("src/akillievsistemi/guvelikresim/kapat.png", 65, 65); // Resmi 65*65 boyutlandır
        kapat.setIcon(lambakapat);
        Font kapatfont = new Font("ARIAL", Font.ITALIC, 15);
        kapat.setFont(kapatfont);
        kapat.setOpaque(false); // Butonun arka planını görünür kıl
        kapat.setForeground(new Color(0,0,0,140));
        kapat.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        kapat.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        kapat.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        ss.add(kapat);
        kapat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sistemikapat();
            }
        });

       //çocuk kilidi
        JButton cocuk=new JButton("Çocuk Kilidi ");
        cocuk.setBounds(205, 285, 135, 100);
        cocuk.setBackground(new Color(255, 241, 118));
        ImageIcon prizfoto = resizeImage("src/akillievsistemi/guvelikresim/çocuk.png", 65, 65); // Resmi 65*65 boyutlandır
        cocuk.setIcon(prizfoto);
        cocuk.setForeground(new Color(0,0,0,140));
        cocuk.setOpaque(false); // Butonun arka planını görünür kıl
        cocuk.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        Font butonpri = new Font("ARIAL", Font.ITALIC, 15);
        cocuk.setFont(butonpri);
        cocuk.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        cocuk.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        cocuk.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        cocuk.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        cocuk.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        ss.add(cocuk);
        cocuk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cocukKilidi();
            }
        });
           
      ss.setVisible(true);
    }
    
        private void cocukKilidi(){
            if(cocukKilidi==false){
                JOptionPane.showMessageDialog(null, "Çocuk kilidi açılıyor.\nÇekmece,dolap kapakları açılmayacaktır");
            }
            else{
                JOptionPane.showMessageDialog(null, "Çocuk kilidi özelliği kapanıyor.\nTekrardan üzerine basarak açabilirsiniz."); 
            }
            cocukKilidi=true;
        }
    
        private void gazKacagi(){
            if(gazKacagi==false){
                JOptionPane.showMessageDialog(null, "Gaz alarmı aktifleşiyor.\nGaz kaçağı tespit edilirse\n alarm çalıcaktır");
            }
            else{
                JOptionPane.showMessageDialog(null, "Gaz alarmı kapatıldı.\nTekrardan basarak açabilirsiniz."); 
            }
            gazKacagi=true;
        }
        
        private void kapiKilidi(){
            if(kapiKilidi==false){
                JOptionPane.showMessageDialog(null, "Kapı kilidi özelliği aktifleşiyor");
            }
            else{
                JOptionPane.showMessageDialog(null, "Kapı kilidi özelliği kapanıyor.\nTekrardan üzerine basarak açabilirsiniz."); 
            }
            kapiKilidi=true;
        }
        
        private void YanginAlarmi(){
            if(yanginAlarmi==false){
                JOptionPane.showMessageDialog(null, "Yangın alarmı aktifleşiyor.\nDuman tespit edilirse\n alarm çalıcaktır");
            }
            else{
                JOptionPane.showMessageDialog(null, "Yangın alarmı kapanıyor.\nTekrardan üzerine basarak açabilirsiniz."); 
            }
            yanginAlarmi=true;
        }
   
    

    
   
        
    
   
    
    private static ImageIcon resizeImage(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage(); // resmi al
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH); // yeni boyutlandır
        return new ImageIcon(newImg); // yeniden ImageIcon olarak döndür
    }

    

}