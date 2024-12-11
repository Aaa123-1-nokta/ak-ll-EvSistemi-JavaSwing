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
public class MutfakAydınlatma1 implements IAydınlatma1 {
    private float isikSiddeti;
    private int amper;
    private boolean acikMi;
    private boolean yemekModu;
    private boolean gece;
    

    // Parametreli yapıcı (Builder kullanarak oluşturulabilir)
    private MutfakAydınlatma1(MutfakAydınlatmaBuilder build) {
        this.isikSiddeti = build.isikSiddeti;
        this.amper = build.amper;
        this.acikMi=build.acikMi;
        this.gece=build.gece;
        this.yemekModu=build.yemek;
    }

    // Builder sınıfı
    public static class MutfakAydınlatmaBuilder {
        private float isikSiddeti;//zoeunlu
        private int amper;//zorunlu
        private boolean acikMi;
        private boolean gece;
        private boolean yemek;
        public MutfakAydınlatmaBuilder(float isikSiddeti,int amper){
            this.isikSiddeti=isikSiddeti;
            this.amper=amper;
        }
        public MutfakAydınlatmaBuilder setacikMi(boolean acikMi) {
            this.acikMi = acikMi;
            return this;
        }
        public MutfakAydınlatmaBuilder setGece(boolean gece) {
            this.gece = gece;
            return this;
        }
        public MutfakAydınlatmaBuilder setYemek(boolean yemek) {
            this.yemek = yemek;
            return this;
        }

        public MutfakAydınlatma1 build() {
            return new MutfakAydınlatma1(this);
        }
    }
    public void startWindow() {
        JFrame ss =new JFrame();
        
        JLabel labelmutfak = new JLabel();
        labelmutfak.setBounds(55, -50, 400, 400); // ana resmin konumu ve boyutu
        ImageIcon a = resizeImage("src/akillievsistemi/aydinlatmaresimler/mutfak.jpeg", 280, 200); // 300*300 boyutunda resmi ayarla
        labelmutfak.setIcon(a);
        ss.add(labelmutfak); // JLabel'i panele ekle
        // Ana frame ayarları
        ss.setTitle("Mutfak Aydınlatması");
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
                new Aydinlatma1();
            }
        }); 
        
        
        //yazı ekleme
        JLabel label1 = new JLabel("Lütfen işlem seçiniz");
        label1.setBounds(75, 120, 300, 300); // Yazının konumu ve boyutu
        label1.setForeground(Color.BLACK);
        Font yazisekli = new Font("Courier New", Font.PLAIN, 20); // Düz Courier New fontu

        label1.setFont(yazisekli);
        ss.add(label1); // JLabel'i pencereye ekle
    
        
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
        ss.add(isikRengi);
         
        isikRengi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new İsikRengi();
            }
        });
        
        
        // Gece modu butonu
        JButton gecemodu = new JButton("Gece modu");
        gecemodu.setBounds(205, 395, 135, 100);
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
        ss.add(gecemodu);
       
        
        gecemodu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                geceModu();
            }
        });
        
        
        //yemek modu butonu için
        JButton yemekbutonu= new JButton("Yemek modu");
        yemekbutonu.setBounds(27, 395, 135, 100);
        yemekbutonu.setBackground(new Color(255, 179, 217)); // Pastel ri
        ImageIcon yemek = resizeImage("src/akillievsistemi/aydinlatmaresimler/yemek.png", 65, 65); // Resmi 65*65 boyutlandır
        yemekbutonu.setIcon(yemek);
        Font yemek23 = new Font("ARIAL", Font.ITALIC, 15);
        yemekbutonu.setFont(yemek23);
        yemekbutonu.setOpaque(false); // Butonun arka planını görünür kıl
        yemekbutonu.setForeground(new Color(0,0,0,140));
        yemekbutonu.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        yemekbutonu.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        yemekbutonu.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        yemekbutonu.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                g.setColor(c.getBackground());
                g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Köşe yarıçapı
                super.paint(g, c);
            }
        });

        yemekbutonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yemekModu();
            }
        }); 
        
        ss.add(yemekbutonu);

        
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
        ss.add(ac);
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
        ss.add(kapat);
        kapat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kapat();
            }
        });

       
        //IŞIK SİDDETİ BUTONU
        JButton isikSiddetiButon = new JButton("Işık Şiddeti Ayarla");
        isikSiddetiButon.setBounds(205, 285, 135, 100);
        isikSiddetiButon.setBackground(new Color(255, 241, 118)); // Pastel ri
        ImageIcon siddet = resizeImage("src/akillievsistemi/aydinlatmaresimler/şiddet.png", 65, 65); // Resmi 65*65 boyutlandır
        isikSiddetiButon.setIcon(siddet);
        Font siddetfont = new Font("ARIAL", Font.ITALIC, 15);
        yemekbutonu.setFont(siddetfont);
        isikSiddetiButon.setOpaque(false); // Butonun arka planını görünür kıl
        isikSiddetiButon.setBorder(BorderFactory.createEmptyBorder()); // Kenarları tamamen kaldır
        isikSiddetiButon.setVerticalTextPosition(SwingConstants.BOTTOM); // Yazıyı altta göster
        isikSiddetiButon.setHorizontalTextPosition(SwingConstants.CENTER); // Yazıyı ortala
        ss.add(isikSiddetiButon);
        
        isikSiddetiButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(ss, "Işık Şiddeti (1-100):");
                if (input != null && !input.isEmpty()) {
                    try {
                        int siddet = Integer.parseInt(input);
                        if (siddet >= 1 && siddet <= 100) {
                            ısık(siddet);
                        } else {
                            JOptionPane.showMessageDialog(ss, "Lütfen 1 ile 100 arasında bir değer giriniz.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(ss, "Lütfen geçerli bir sayı giriniz.");
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
           
      ss.setVisible(true);
    }
    
   
    private float getIsikSiddeti(){
        return this.isikSiddeti;
    }

    
   @Override
    public void geceModu() {
        if(gece==false){
            JOptionPane.showMessageDialog(null, "Gece modu açılmıştır.\nTekrardan üstüne basıp kapatabilirsiniz.");
            gece=true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Gece modu kapanmıştır.\nTekrardan üstüne basıp \ngece modunu aktifleştirebilirsiniz.");
            gece=false;
        }
    }
        
    
    @Override
    public void kapat() {
        if(acikMi==false){
        JOptionPane.showMessageDialog(null, "Mutfak aydınlatmanız zaten kapalı konumdadır.");
        acikMi=true;
        }
        else{
           JOptionPane.showMessageDialog(null, "Mutfak aydınlatmanız kapatılıyor."); 
        }
        acikMi=false;
    }
    
    public void ısık(int siddet){
        JOptionPane.showMessageDialog(null, "Mutfak aydınlatmanız "+siddet+ " olarak ayarlandı");
    }
    
    @Override
    public void AcModu(){
        if(acikMi==false){
        JOptionPane.showMessageDialog(null, "Mutfak aydınlatmanız açılıyor  .\nSiddeti="+amper);
        }
        else{
           JOptionPane.showMessageDialog(null, "Mutfak aydınlatmanız zaten açıktır."); 
        }
        acikMi=true;
    }
    
    private void yemekModu(){
       if(yemekModu==false){
         JOptionPane.showMessageDialog(null, "Yemek modu açılmıştır.\nTekrardan basıp kapatabilirsiniz.");
            yemekModu=true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Yemek modu kapanmıştır.\nDilerseniz tekrardan üstüne basarak \nyemek modunu aktifleştirebilirsiniz.");
            yemekModu=false;
        }
    }
    
    private static ImageIcon resizeImage(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage(); // resmi al
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH); // yeni boyutlandır
        return new ImageIcon(newImg); // yeniden ImageIcon olarak döndür
    }

    
}