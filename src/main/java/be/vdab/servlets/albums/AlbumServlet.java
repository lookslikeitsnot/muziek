package be.vdab.servlets.albums;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Album;
import be.vdab.services.AlbumService;
import be.vdab.util.StringUtils;

@WebServlet("/albums/album.htm")
public class AlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/albums/album.jsp";
	private final transient AlbumService albumService = new AlbumService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null && StringUtils.isLong(id)) {
			Optional<Album> optionalAlbum = albumService.read(Long.parseLong(id));
			if (optionalAlbum.isPresent()) {
				request.setAttribute("album", optionalAlbum.get());
				request.getRequestDispatcher(VIEW).forward(request, response);
			}
			else {
				response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
			}
		} else {
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
		}

	}

}
