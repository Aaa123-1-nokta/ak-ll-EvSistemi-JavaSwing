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

public class BalkonAydınlatma1 implements IAydınlatma1{
    private float isikSiddeti;//zorunlu
    public boolean acikHavaModu;
    private int siddet;//zorunlu
    private boolean balkonlamba;
    private BalkonAydınlatma1(BalkonAydınlatmaBuilder balkonbuilder) {
        this.siddet=balkonbuilder.siddet;
        this.isikSiddeti=balkonbuilder.isikSiddeti;
        this.acikHavaModu=balkonbuilder.acikHavaModu;
        this.balkonlamba=balkonbuilder.balkonlamba;
    } 
    public static class BalkonAydınlatmaBuilder {
        private float isikSiddeti;
        private int siddet;
        private boolean acikHavaModu;
        private boolean balkonlamba;
        public BalkonAydınlatmaBuilder(float sikSiddeti,int siddet){
            this.isikSiddeti=isikSiddeti;
            this.siddet=siddet;
        }
        public BalkonAydınlatmaBuilder setacikhavaModuu(boolean acikHavaModu ){
            this.acikHavaModu=acikHavaModu;
            return this;
        }
        public BalkonAydınlatmaBuilder setbalkonlamba(boolean balkonlamba ){
            this.balkonlamba=balkonlamba;
            return this;
        }
        
        public BalkonAydınlatma1 build() {
            return new BalkonAydınlatma1(this);
        }
    }
       public void balkonuı(){
        JFrame balkon =new JFrame();
        
        JLabel labelmutfak = new JLabel();
        labelmutfak.setBounds(55, -50, 400, 400); // ana resmin konumu ve boyutu
        ImageIcon balkonicon = resizeImage("src/akillievsistemi/aydinlatmaresimler/balkon.png", 280, 200); // 300*300 boyutunda resmi ayarla
        labelmutfak.setIcon(balkonicon);
        balkon.add(labelmutfak); // JLabel'i panele ekle
        // Ana frame ayarları
        balkon.setTitle("Balkon  Aydınlatması");
        balkon.setSize(370, 679);
        balkon.setLocationRelativeTo(null); // Pencereyi ortala
        balkon.setLayout(null);
        balkon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        balkon.getContentPane().setBackground(Color.WHITE);
        
        // Resim Label'ı
        JLabel labelmu = new JLabel();
        labelmu.setBounds(0, -340, 390, 710); // saat konumu ve boyutu
        ImageIcon resim2 = resizeImage("src/akillievsistemi/aydinlatmaresimler/saat.png", 370, 36); // 200x200 boyutunda resmi ayarla
        labelmu.setIcon(resim2);
        balkon.add(labelmu); // JLabel'i panele ekle
        
        JLabel label3 = new JLabel();
        label3.setBounds(-5, 433, 390, 400); // saat konumu ve boyutu
        ImageIcon kı = resizeImage("src/akillievsistemi/aydinlatmaresimler/kısayol2.png", 380, 38); // 200x200 boyutunda resmi ayarla
        label3.setIcon(kı);
        balkon.add(label3); // JLabel'i panele ekle
        
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
        balkon.add(geri); // Aydınlatma butonunu panele ekle
        //geri butonuna basıldığında
        geri.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            // Mevcut Aydınlatma sınıfına git
                new Aydinlatma1();
            }
        }); 
        
        
        //yazı ekleme
        JLabel label1 = new JLabel("Lütfen işlem seçiniz");
        label1.setBounds(75, 120, 300, 300); // Yazının konumu ve boyutu
        label1.setForeground(Color.BLACK);
        Font yazisekli = new Font("Courier New", Font.PLAIN, 20); // Düz Courier New fontu

        label1.setFont(yazisekli);
        balkon.add(label1); // JLabel'i pencereye ekle
    
        
        
        
        //gun doğumu ayarı
        JButton gunDogumu = new JButton("Gün Doğumu");
        gunDogumu.setBounds(205,285,135, 100);
        gunDogumu.setBackground(new Color( 212, 106, 106)); // Pastel ri
        ImageIcon gundogumuresim= resizeImage("src/akillievsistemi/aydinlatmaresimler/bulut2.png", 65, 65); // Resmi 65*65 boyutlandır
        gunDogumu.setIcon(gundogumuresim);
        Font kapatfont = new Font("ARIAL", Font.ITALIC, 15);
        gunDogumu.setFont(kapatfont);
        gunDogumu.setOpaque(false); // Butonun arka planını görünür kıl
        gunDogumu.setForeground(new Color(0,0,0,140));
        gunDogumu.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        gunDogumu.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        gunDogumu.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        balkon.add(gunDogumu);
        gunDogumu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gunDogumu();
            }
        });
        
        //açık hava modu
        
        JButton acikHava = new JButton("Açık Hava");
        acikHava.setBounds(205,395,135, 100);
        acikHava.setBackground(new Color( 163, 193, 224)); // Pastel ri
        ImageIcon acikHavaresim= resizeImage("src/akillievsistemi/aydinlatmaresimler/acikhava.png", 65, 65); // Resmi 65*65 boyutlandır
        acikHava.setIcon(acikHavaresim);
        Font havafont = new Font("ARIAL", Font.ITALIC, 15);
        acikHava.setFont(havafont);
        acikHava.setOpaque(false); // Butonun arka planını görünür kıl
        acikHava.setForeground(new Color(0,0,0,140));
        acikHava.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        acikHava.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        acikHava.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        balkon.add(acikHava);
        acikHava.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acikhava();
            }
        });
        
        // Işık rengi butonu
        JButton isikRengi = new JButton("Işık Rengi");
        isikRengi.setBounds(27, 285,135, 100);
        isikRengi.setBackground(new Color(169, 169, 169)); // Pastel ri
        ImageIcon icon = resizeImage("src/akillievsistemi/aydinlatmaresimler/renk11.png", 70, 70); // Resmi 70x70 boyutlandır
        isikRengi.setIcon(icon);
        Font butonaydinlatma = new Font("ARIAL", Font.ITALIC, 15);
        isikRengi.setFont(butonaydinlatma);
       
        isikRengi.setOpaque(false); // Butonun arka planını görünür kıl
        isikRengi.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        isikRengi.setForeground(new Color(0,0,0,140));
        isikRengi.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        isikRengi.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        isikRengi.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        balkon.add(isikRengi);
         
        isikRengi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new İsikRengi();
            }
        });
        
        
        
        // Gece modu butonu
        JButton gecemodu = new JButton("Gece modu");
        gecemodu.setBounds(27, 395, 135, 100);
        gecemodu.setBackground(new Color(76, 106, 146));
        ImageIcon gece = resizeImage("src/akillievsistemi/aydinlatmaresimler/gece.png", 65, 65); // Resmi 65*65 boyutlandır
        gecemodu.setIcon(gece);
        Font butongece = new Font("ARIAL", Font.ITALIC, 15);
        gecemodu.setFont(butongece);
        gecemodu.setOpaque(false); // Butonun arka planını görünür kıl
        gecemodu.setForeground(new Color(0,0,0,140));
        gecemodu.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        gecemodu.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        gecemodu.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        gecemodu.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        balkon.add(gecemodu);
       
        
        gecemodu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                geceModu();
            }
        });
        
        //ac butonu
        JButton ac = new JButton("Lamba aç");
        ac.setBounds(27, 505, 135, 100);
        ac.setBackground(new Color(119, 221, 119)); // Pastel ri
        ImageIcon lambaac = resizeImage("src/akillievsistemi/aydinlatmaresimler/aç.png", 65, 65); // Resmi 65*65 boyutlandır
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
        balkon.add(ac);
        ac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AcModu();
            }
        });
       
        
        //yemek modu
        
        //kapat butonu
        JButton kapat = new JButton("Lamba kapat");
        kapat.setBounds(205,505,135, 100);
        kapat.setBackground(new Color( 255, 105, 97)); // Pastel ri
        ImageIcon lambakapat= resizeImage("src/akillievsistemi/aydinlatmaresimler/kapat2.png", 65, 65); // Resmi 65*65 boyutlandır
        kapat.setIcon(lambakapat);
        Font kapatfontt = new Font("ARIAL", Font.ITALIC, 15);
        kapat.setFont(kapatfontt);
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
        balkon.add(kapat);
        kapat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kapat();
            }
        });
           
      balkon.setVisible(true);
    }
    
   
 private double getIsikSiddeti(){
     return this.isikSiddeti;
     
 }

    
   @Override
    public void geceModu() {
         if(acikHavaModu){
            JOptionPane.showMessageDialog(null, "Balkon lambanız gece moduna geçmiştir.\nIşık şiddetiniz: " + getIsikSiddeti()+" lüks");
            acikHavaModu=false;
        }
        else{
            JOptionPane.showMessageDialog(null, "Balkon ışığı gece modu kapatılıyor.");
           
         
        }

    }
        

    public void ısıkrengi() {
          //IŞIK RENGİ İÇİN FRAME OLUŞTURDU
        JFrame isikRengiFrame=new JFrame("IŞIK RENGİ");
        isikRengiFrame.setSize(409, 480);
        isikRengiFrame.setLocationRelativeTo(null); // Pencereyi sayfanın ortasında aç
        isikRengiFrame.setLayout(null);
        isikRengiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        isikRengiFrame.getContentPane().setBackground(Color.BLACK);
        
        //Geri butonu için
        JButton geributonu2= new JButton("◀︎");
        geributonu2.setBounds(10, 56, 25, 25);
        geributonu2.setBackground(Color.WHITE);
        geributonu2.setForeground(Color.BLACK);
        geributonu2.setOpaque(false); // Butonun arka planını görünür kıl
        geributonu2.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        geributonu2.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 100, 100); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        isikRengiFrame.add(geributonu2);
        geributonu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Aydinlatma1();
            }
        }); 

        
        
        
        
        //yazı ekleme
        JLabel ışıkRengiLabel = new JLabel("Lütfen Işık Rengini Seçiniz");
        ışıkRengiLabel.setBounds(80, 50, 500, 34); // Yazının konumu ve boyutu
        ışıkRengiLabel.setForeground(Color.WHITE);
        Font yazisekli = new Font("ARIAL", Font.BOLD, 21);
        ışıkRengiLabel.setFont(yazisekli);
        isikRengiFrame.add(ışıkRengiLabel); // JLabel'i pencereye ekle
        
        //yeşil balkon için
        JButton yesilbalkon = new JButton("YEŞİL");
        yesilbalkon.setBounds(20, 120, 170, 90);
        yesilbalkon.setBackground(Color.green);
        yesilbalkon.setForeground(Color.BLACK);
        yesilbalkon.setOpaque(false); // Butonun arka planını görünür kıl
        yesilbalkon.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        Font butonyesil = new Font("ARIAL", Font.ITALIC, 20);
        yesilbalkon.setFont(butonyesil);
        yesilbalkon.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 1000, 1000); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        yesilbalkon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Balkon aydınlatmanız ' YEŞİL ' olarak ayarlanmıştır.");
                
            }
        });
        isikRengiFrame.add(yesilbalkon);
        
        
        //pembe balkon için
        JButton pembebalkon = new JButton("PEMBE");
        pembebalkon.setBounds(220, 120, 170, 90);
        pembebalkon.setBackground(Color.pink);
        pembebalkon.setForeground(Color.BLACK);
        pembebalkon.setOpaque(false); // Butonun arka planını görünür kıl
        pembebalkon.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        Font butonpembe = new Font("ARIAL", Font.ITALIC, 20);
        pembebalkon.setFont(butonpembe);
        pembebalkon.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 1000, 1000); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        
        pembebalkon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Balkon aydınlatmanız ' PEMBE ' olarak ayarlanmıştır.");
            }
        });
        
        
        isikRengiFrame.add(pembebalkon);
        
        
        //mavi balkon için
         JButton mavibalkon = new JButton("MAVİ");
        mavibalkon.setBounds(220, 230, 170, 90);
        mavibalkon.setBackground(Color.BLUE);
        mavibalkon.setForeground(Color.BLACK);
        mavibalkon.setOpaque(false); // Butonun arka planını görünür kıl
        mavibalkon.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        Font butonmavi = new Font("ARIAL", Font.ITALIC, 20);
        mavibalkon.setFont(butonmavi);
        mavibalkon.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 1000, 1000); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        mavibalkon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Balkon aydınlatmanız ' MAVİ ' olarak ayarlanmıştır.");
            }
        });
        
        
        isikRengiFrame.add(mavibalkon);
        
        //turuncu balkon için
        JButton turuncubalkon = new JButton("TURUNCU");
        turuncubalkon.setBounds(20, 230, 170, 90);
        turuncubalkon.setBackground(Color.orange);
        turuncubalkon.setForeground(Color.BLACK);
        turuncubalkon.setOpaque(false); // Butonun arka planını görünür kıl
        turuncubalkon.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        Font butonturuncu = new Font("ARIAL", Font.ITALIC, 20);
        turuncubalkon.setFont(butonpembe);
        turuncubalkon.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 1000, 1000); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        
        turuncubalkon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Balkon aydınlatmanız ' TURUNCU ' olarak ayarlanmıştır.");
            }
        });
        isikRengiFrame.add(turuncubalkon);
        
        //beyaz balkon için
        JButton beyazbalkon = new JButton("BEYAZ");
        beyazbalkon.setBounds(20, 340, 170, 90);
        beyazbalkon.setBackground(Color.WHITE);
        beyazbalkon.setForeground(Color.BLACK);
        beyazbalkon.setOpaque(false); // Butonun arka planını görünür kıl
        beyazbalkon.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        Font butonbeyaz = new Font("ARIAL", Font.ITALIC, 20);
        beyazbalkon.setFont(butonbeyaz);
        beyazbalkon.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 1000, 1000); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        
        beyazbalkon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Balkon aydınlatmanız ' BEYAZ ' olarak ayarlanmıştır.");
            }
        });
        isikRengiFrame.add(beyazbalkon);
        
        
        //kırmızı balkon için
        JButton kırmızı = new JButton("KIRMIZI");
        kırmızı.setBounds(220, 340, 170, 90);
        kırmızı.setBackground(Color.RED);
        kırmızı.setForeground(Color.BLACK);
        kırmızı.setOpaque(false); // Butonun arka planını görünür kıl
        kırmızı.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        Font kırmızıı = new Font("ARIAL", Font.ITALIC, 20);
        kırmızı.setFont(kırmızıı);
        kırmızı.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 1000, 1000); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
        
        kırmızı.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Balkon aydınlatmanız ' KIRMIZI ' olarak ayarlanmıştır.");
            }
        });
        isikRengiFrame.add(kırmızı);
        isikRengiFrame.setVisible(true);
    }

    @Override
    public void kapat() {
        if(balkonlamba==true){
        JOptionPane.showMessageDialog(null, "Balkon aydınlatmanız zaten kapalı konumdadır.");
        balkonlamba=false;
        }
        else{
           JOptionPane.showMessageDialog(null, "Balkon aydınlatmanız kapatılıyor."); 
        }
        balkonlamba=true;

    }
    
    
    private void gunDogumu(){
        JOptionPane.showMessageDialog(null, "Balkon ışığınız gün doğumuna göre yavaşça açılacaktır.");
    }
    
    public void acikhava(){
        if(acikHavaModu==true){
            JOptionPane.showMessageDialog(null, "Balkon ışığı açık hava moduna ayarlandı.\nTekrardan üzerine basarak kapatabilirsiniz");
             acikHavaModu=false;
        }
        else{
            JOptionPane.showMessageDialog(null, "Balkon ışığı açık hava modu kapatılıyor.");
                        acikHavaModu=true;

         
        }
    }
    
    @Override
    public void AcModu(){
        if(balkonlamba==true){
        JOptionPane.showMessageDialog(null, "Balkon aydınlatmanız açılıyor  .\nSiddeti="+siddet);
        }
        else{
           JOptionPane.showMessageDialog(null, "Balkon aydınlatmanız zaten açıktır."); 
        }
        balkonlamba=false;

    }
    
    private static ImageIcon resizeImage(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage(); // resmi al
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH); // yeni boyutlandır
        return new ImageIcon(newImg); // yeniden ImageIcon olarak döndür
    }
    
    
    
    
    
    
    
}
