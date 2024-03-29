package net.minecraft.src;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.List;
import net.minecraft.src.ILogAgent;
import net.minecraft.src.INetworkManager;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class MemoryConnection implements INetworkManager {

   private static final SocketAddress field_74444_a = new InetSocketAddress("127.0.0.1", 0);
   private final List field_74442_b;
   private final ILogAgent field_98214_c;
   private MemoryConnection field_74443_c;
   private NetHandler field_74440_d;
   private boolean field_74441_e;
   private String field_74438_f;
   private Object[] field_74439_g;


   public void func_74425_a(NetHandler p_74425_1_) {
      this.field_74440_d = p_74425_1_;
   }

   public void func_74429_a(Packet p_74429_1_) {
      if(!this.field_74441_e) {
         this.field_74443_c.func_74436_b(p_74429_1_);
      }
   }

   public void func_74427_a() {}

   public void func_74428_b() {
      int var1 = 2500;

      while(var1-- >= 0 && !this.field_74442_b.isEmpty()) {
         Packet var2 = (Packet)this.field_74442_b.remove(0);
         var2.func_73279_a(this.field_74440_d);
      }

      if(this.field_74442_b.size() > var1) {
         this.field_98214_c.func_98236_b("Memory connection overburdened; after processing 2500 packets, we still have " + this.field_74442_b.size() + " to go!");
      }

      if(this.field_74441_e && this.field_74442_b.isEmpty()) {
         this.field_74440_d.func_72515_a(this.field_74438_f, this.field_74439_g);
      }

   }

   public SocketAddress func_74430_c() {
      return field_74444_a;
   }

   public void func_74423_d() {
      this.field_74441_e = true;
   }

   public void func_74424_a(String p_74424_1_, Object ... p_74424_2_) {
      this.field_74441_e = true;
      this.field_74438_f = p_74424_1_;
      this.field_74439_g = p_74424_2_;
   }

   public int func_74426_e() {
      return 0;
   }

   public void func_74436_b(Packet p_74436_1_) {
      if(p_74436_1_.func_73277_a_() && this.field_74440_d.func_72469_b()) {
         p_74436_1_.func_73279_a(this.field_74440_d);
      } else {
         this.field_74442_b.add(p_74436_1_);
      }

   }

}
