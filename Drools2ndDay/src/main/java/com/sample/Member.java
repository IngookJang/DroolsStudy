package com.sample;

public class Member {
     private String name;
     private String section;
     private int height;

     public Member(String name, String section, int height) {
          super();
          this.name = name;
          this.section = section;
          this.height = height;
     }

     public String getSection() {
          return section;
     }

     public void setSection(String name) {
          this.section = name;
     }

     public int getHeight() {
          return height;
     }

     public void setHeight(int height) {
          this.height = height;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

}