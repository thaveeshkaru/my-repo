/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.dto;

/**
 *
 * @author DELL
    */
   public class MemberDto {
        private String memberID;
        private String memberName;
        private String address;
        private int contact;

        public MemberDto(String memberID, String memberName, String address, int contact) {
            this.memberID = memberID;
            this.memberName = memberName;
            this.address = address;
            this.contact = contact;
        }

        public String getMemberID() {
            return memberID;
        }

        public void setMemberID(String memberID) {
            this.memberID = memberID;
        }

        public String getMemberName() {
            return memberName;
        }

        public void setMemberName(String memberName) {
            this.memberName = memberName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getContact() {
            return contact;
        }

        public void setContact(int contact) {
            this.contact = contact;
        }

        @Override
        public String toString() {
            return "MemberDto{" + "memberID=" + memberID + ", memberName=" + memberName + ", address=" + address + ", contact=" + contact + '}';
        }
       
   }
