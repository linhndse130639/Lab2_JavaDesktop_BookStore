/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.daos;



import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import linhnd.dtos.DiscountDTO;
import linhnd.conns.Myconnection;

/**
 *
 * @author Duc Linh
 */
public class DiscountDAO implements Serializable{
    Connection conn = null;
    PreparedStatement preStm = null;
    ResultSet rs = null;

    public DiscountDAO() {
    }
    
    private void closeConnection() throws Exception{
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    
    public DiscountDTO getDiscountPro(String codePro) throws Exception{
        String desDis,codeDis;
        DiscountDTO dto = null;
        try {
            String sql = "SELECT descriptionDiscount,codeDiscount FROM dbo.Discount WHERE discountID = ? ";
            conn = Myconnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, codePro);
            rs = preStm.executeQuery();
            if (rs.next()) {
                desDis = rs.getString("descriptionDiscount");
                codeDis = rs.getString("codeDiscount");
                dto = new DiscountDTO(codeDis, desDis);
            }   
        }finally{
            closeConnection();
        }
        return dto;
    }
    public boolean checkDiscount(String userID,String codeDis) throws Exception{
        boolean check = false;
        try {
            String sql = "SELECT userID FROM dbo.UserHaveDiscount WHERE userID = ? AND discountID = ? ";
            conn = Myconnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userID);
            preStm.setString(2, codeDis);
            rs = preStm.executeQuery();
            if (rs.next()) {
                check = true;
            }
        }finally{
            closeConnection();
        }
        return check;
    }
    public boolean checkCodeDis(String code) throws Exception{
        boolean check = true;
        try {
            String sql = "SELECT discountID FROM dbo.Discount WHERE discountID = ?";
            conn = Myconnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, code);
            rs = preStm.executeQuery();
            if (rs.next()) {
                check = false;
            }
        }finally{
            closeConnection();
        }
        return check;
    }
    public boolean createNewDis(DiscountDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "INSERT dbo.Discount VALUES  ( ?,?,?,? )";
            conn = Myconnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getDisID());
            preStm.setString(2, dto.getDesDis());
            preStm.setString(3, dto.getCodeDis());
            preStm.setString(4, dto.getDateDis());
            check = preStm.executeUpdate() > 0;
        }finally{
            closeConnection();
        }
        return check;
    }
    public List<DiscountDTO> getAllDiscount() throws Exception{
        List<DiscountDTO> result = new ArrayList<>();
        DiscountDTO dto = null;
        try {
            String sql = "SELECT discountID,descriptionDiscount,codeDiscount,DateDiscount FROM dbo.Discount ";
            conn = Myconnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {                
                String discountID = rs.getString("discountID");
                String descriptionDiscount = rs.getString("descriptionDiscount");
                String codeDiscount = rs.getString("codeDiscount");
                String DateDiscount = rs.getString("DateDiscount");
                dto = new DiscountDTO(codeDiscount, descriptionDiscount, discountID, DateDiscount);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean checkDiscountCode(String disCode) throws Exception {
        boolean check = true;
        try {
            String sql = "SELECT discountID FROM dbo.Discount WHERE discountID = ? ";
            conn = Myconnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, disCode);
            rs = preStm.executeQuery();
            if (rs.next()) {
                check = false;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    public boolean deleteDiscount(String disID) throws Exception{
        boolean check = false;
        try {
            String sql = "DELETE dbo.Discount WHERE discountID = ? ";
            conn = Myconnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, disID);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return  check;
    }

}
