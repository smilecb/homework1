package text;

import com.blb.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/text")
public class textconnect extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            DBUtil.execute("INSERT INTO TEXT (temp) VALUES (?)","100");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
