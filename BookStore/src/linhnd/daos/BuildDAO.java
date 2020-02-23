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
import linhnd.conns.Myconnection;
import linhnd.dtos.BuildDTO;

/**
 *
 * @author Duc Linh
 */
public class BuildDAO implements Serializable{
    Connection conn = null;
    PreparedStatement preStm = null;
    ResultSet rs = null;

    public BuildDAO() {
    }
    
    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (rs != null) {
            rs.close();
        }
    }

    public boolean insertBuild(BuildDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT dbo.Builds\n"
                    + "VALUES  ( ? , \n"
                    + "          ? , \n"
                    + "          ? , \n"
                    + "          ? , \n"
                    + "          ? ,\n"
                    + "          ? , \n"
                    + "          ? \n"
                    + "        )";
            conn = Myconnection.getMyConnection();
            preStm =  conn.prepareStatement(sql);
            preStm.setString(1, dto.getBuildId());
            preStm.setString(2, dto.getDateBuild());
            preStm.setString(3, dto.getTotalBuild());
            preStm.setString(4, dto.getPayment());
            preStm.setString(5, dto.getStatusBuild());
            preStm.setString(6, dto.getDesBuild());
            preStm.setString(7, dto.getUserD());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}