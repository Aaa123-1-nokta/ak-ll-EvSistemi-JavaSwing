package akillievsistemi;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
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


public class SalonAydınlatma implements IAydınlatma1{
    private float isikSiddeti;//zorunlu
    private boolean kapaliMi;
    private boolean gece;
    public boolean etkileşim;
    private int akim;//zorunlu
    private SalonAydınlatma(SalonAydınlatmaBuilder Buildersalon) {
        this.akim=Buildersalon.akim;
        this.isikSiddeti=Buildersalon.isikSiddeti;
        this.etkileşim=Buildersalon.etkileşim;
        this.gece=Buildersalon.gece;
        this.kapaliMi=Buildersalon.kapaliMi;
    }
     public static class SalonAydınlatmaBuilder {
        private float isikSiddeti;
        private boolean kapaliMi;
        private boolean gece;
        public boolean etkileşim;
        private int akim;
        public SalonAydınlatmaBuilder(float sikSiddeti,int akim){
            this.isikSiddeti=isikSiddeti;
            this.akim=akim;
        }
        public SalonAydınlatmaBuilder setKapaliMİ(boolean kapaliMi ){
            this.kapaliMi=kapaliMi;
            return this;
        }
        public SalonAydınlatmaBuilder setEtkilesim(boolean etkilesim ){
            this.etkileşim=etkilesim;
            return this;
        }
        public SalonAydınlatmaBuilder setGece(boolean gece ){
            this.gece=gece;
            return this;
        }
        public SalonAydınlatma build() {
            return new SalonAydınlatma(this);
        }
    }
        public void salonuı(){
        JLabel salon = new JLabel();
        JFrame salonaydin=new JFrame("Salon aydınlatma");
        salon.setBounds(55, -50, 400, 400); // ana resmin konumu ve boyutu
        ImageIcon a = resizeImage("src/akillievsistemi/aydinlatmaresimler/salonrenk.png", 280, 200); // 250*200 boyutunda resmi ayarla
        salon.setIcon(a);
        salonaydin.add(salon); // JLabel'i panele ekle
        // Ana frame ayarları
        salonaydin.setTitle("Salon Aydınlatması");
        salonaydin.setSize(370, 679);
        salonaydin.setLocationRelativeTo(null); // Pencereyi ortala
        salonaydin.setLayout(null);
        salonaydin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        salonaydin.getContentPane().setBackground(Color.WHITE);
        
        // Resim Label'ı
        JLabel labelmu = new JLabel();
        labelmu.setBounds(0, -340, 390, 710); // saat konumu ve boyutu
        ImageIcon resim2 = resizeImage("src/akillievsistemi/aydinlatmaresimler/saat.png", 370, 36); // 200x200 boyutunda resmi ayarla
        labelmu.setIcon(resim2);
        salonaydin.add(labelmu); // JLabel'i panele ekle
        
        JLabel label3 = new JLabel();
        label3.setBounds(-5, 433, 390, 400); // saat konumu ve boyutu
        ImageIcon kı = resizeImage("src/akillievsistemi/aydinlatmaresimler/kısayol2.png", 380, 38); // 200x200 boyutunda resmi ayarla
        label3.setIcon(kı);
        salonaydin.add(label3); // JLabel'i panele ekle
        
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
        salonaydin.add(geri); // Aydınlatma butonunu panele ekle
        //geri butonuna basıldığında
        geri.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            // Mevcut Aydınlatma sınıfına git
                new Aydinlatma1();
            }
        }); 
        
        
        //yazı ekleme
        JLabel label1 = new JLabel("Lütfen işlem seçiniz");
        label1.setBounds(70, 120, 300, 300); // Yazının konumu ve boyutu
        label1.setForeground(Color.BLACK);
        Font yazisekli = new Font("Courier New", Font.PLAIN, 20); // Düz Courier New fontu

        label1.setFont(yazisekli);
        salonaydin.add(label1); // JLabel'i pencereye ekle
    
        
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
        salonaydin.add(isikRengi);
         
        isikRengi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new İsikRengi();
            }
        });
        
        
        // Gece modu butonu
        JButton gecemodu = new JButton("Gece modu");
        gecemodu.setBounds(205, 395, 135, 100);
        gecemodu.setBackground(new Color(163, 193, 224));
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
        salonaydin.add(gecemodu);
       
        
        gecemodu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                geceModu();
            }
        });
        
        
        //yemek modu butonu için
        JButton etkibutonu= new JButton("Etkileşim modu");
        etkibutonu.setBounds(27, 395, 135, 100);
        etkibutonu.setBackground(new Color(168, 227, 216)); // Pastel ri
        ImageIcon yemek = resizeImage("src/akillievsistemi/aydinlatmaresimler/hareket2.png", 65, 65); // Resmi 65*65 boyutlandır
        etkibutonu.setIcon(yemek);
        Font yemek23 = new Font("ARIAL", Font.ITALIC, 15);
        etkibutonu.setFont(yemek23);
        etkibutonu.setOpaque(false); // Butonun arka planını görünür kıl
        etkibutonu.setForeground(new Color(0,0,0,140));
        etkibutonu.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        etkibutonu.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        etkibutonu.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        etkibutonu.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });

        etkibutonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etkilesimli();
            }
        }); 
        
        salonaydin.add(etkibutonu);

        
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
        salonaydin.add(ac);
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
        salonaydin.add(kapat);
        kapat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kapat();
            }
        });

       
        //IŞIK SİDDETİ BUTONU
        JButton isikSiddetiButon = new JButton("Işık Şiddeti Ayarla");
        isikSiddetiButon.setBounds(205, 285, 135, 100);
        isikSiddetiButon.setBackground(new Color(215, 178, 225)); 
        ImageIcon siddet = resizeImage("src/akillievsistemi/aydinlatmaresimler/şiddet.png", 65, 65); // Resmi 65*65 boyutlandır
        isikSiddetiButon.setIcon(siddet);
        Font siddetfont = new Font("ARIAL", Font.ITALIC, 15);
        isikSiddetiButon.setFont(siddetfont);
        isikSiddetiButon.setOpaque(false); // Butonun arka planını görünür kıl
        isikSiddetiButon.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        isikSiddetiButon.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        isikSiddetiButon.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        salonaydin.add(isikSiddetiButon);
        
        isikSiddetiButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(salonaydin, "Işık Şiddeti (1-100):");
                if (input != null && !input.isEmpty()) {
                    try {
                        int siddet = Integer.parseInt(input);
                        if (siddet >= 1 && siddet <= 100) {
                            ısık(siddet);
                        } else {
                            JOptionPane.showMessageDialog(salonaydin, "Lütfen 1 ile 100 arasında bir değer giriniz.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(salonaydin, "Lütfen geçerli bir sayı giriniz.");
                    }
                }
            }
        });
        // Butonun oval yapısı
        isikSiddetiButon.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });
           
      salonaydin.setVisible(true);
    }
    
   
    public double getIsikSiddeti(){
        return this.isikSiddeti;
    }
 
    
    @Override
    public void geceModu() {
         if(gece==true){
            JOptionPane.showMessageDialog(null, "Salon ışığı gece moduna geçmiştir.\nIşık şiddetiniz: " + getIsikSiddeti()+" lüks");
            gece=false;
        }
        else{
            JOptionPane.showMessageDialog(null, "Salon ışığı gece modu kapatılıyor.\nDilerseniz tejrardan tıklayarak gece modunu aktif hale getirebilirsiniz.");
                       gece=true;
        }
    }
       
        
        
    private void ısıkrengi() {
        new İsikRengi();
    }

    @Override
    public void kapat() {
        if(kapaliMi==true){
        JOptionPane.showMessageDialog(null, "Salonı aydınlatmanız zaten kapalı konumdadır.");
        kapaliMi=false;
        }
        else{
           JOptionPane.showMessageDialog(null, "Salon aydınlatmanız kapatılıyor."); 
        }
        kapaliMi=true;

    }
    
    private static ImageIcon resizeImage(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage(); // resmi al
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH); // yeni boyutlandır
        return new ImageIcon(newImg); // yeniden ImageIcon olarak döndür
    }
    
    @Override
    public void AcModu(){
        if(kapaliMi==true){
        JOptionPane.showMessageDialog(null, "Salon aydınlatmanız açılıyor\nSiddeti="+akim);
        }
        else{
           JOptionPane.showMessageDialog(null, "Salon aydınlatmanız zaten açıktır."); 
        }
        kapaliMi=false;

        
                

    }
    
    private void ısık(int siddet){
        JOptionPane.showMessageDialog(null, "Salon aydınlatmanız "+siddet+ " olarak ayarlandı");

    }
    
    private void etkilesimli(){
        if(etkileşim){
            JOptionPane.showMessageDialog(null, "Salon aydınlatmanız etkileşimli olarak açılıp kapanacaktır.");
            etkileşim=false;
        }
        else{
            JOptionPane.showMessageDialog(null, "Salon aydınlatması etkileşim özelliği devre dışı bırakılıyor.\nDilerseniz tekrardan tıklayarak etkileşim özelliğini açabilirsiniz.");
           
         
        }


    }
    
    
    
    
    
    
    
    
    
    


    
    
    
}

