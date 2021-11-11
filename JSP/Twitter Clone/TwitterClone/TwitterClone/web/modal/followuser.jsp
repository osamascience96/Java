<%@page import="helper.CheckFollowedHelper"%>
<%@page import="Bean.Followed"%>
<%@page import="Bean.User"%>
<%@page import="java.util.ArrayList"%>
<!-- Modal -->
<div id="follow_users_modal" class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="followedtitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="followedtitle">Follow Users</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
              <table class="table">
                  <thead>
                      <tr>
                          <th scope="col">Username</th>
                          <th scope="col">Follow</th>
                      </tr>
                  </thead>
                  <tbody>
                      <%
                          if(session.getAttribute("followuserlist") != null){
                            User userobjectfollowuser = (User) session.getAttribute("userObj");
                            ArrayList<User> arrayListUsers = (ArrayList<User>) session.getAttribute("userlist");
                            ArrayList<Followed> arrayListFollowed = (ArrayList<Followed>) session.getAttribute("followuserlist");
                      %>
                        <%
                            if(arrayListFollowed.size() > 0){
                        %>
                            <%
                                for(int i=0; i < arrayListUsers.size(); i++){
                            %>
                                <%
                                    if(arrayListUsers.get(i).getId() != userobjectfollowuser.getId()){
                                %>
                                    <%
                                        // if the current user is followed
                                        if(CheckFollowedHelper.CheckFollowedUserExists(arrayListFollowed, arrayListUsers.get(i).getId())){
                                    %>
                                        <tr>
                                            <td><%=arrayListUsers.get(i).getUsername()%></td>
                                            <td><button class="btn btn-outline-danger" onclick="unfollowuser(<%=userobjectfollowuser.getId()%>, <%=arrayListUsers.get(i).getId()%>)">Unfollow <i class="fa fa-times" aria-hidden="true"></i></button></td>
                                        </tr>
                                    <% }else{%>
                                        <tr>
                                            <td><%=arrayListUsers.get(i).getUsername()%></td>
                                            <td><button class="btn btn-outline-primary" onclick="followuser(<%=userobjectfollowuser.getId()%>, <%=arrayListUsers.get(i).getId()%>)">Follow <i class="fa fa-check" aria-hidden="true"></i></button></td>
                                        </tr>
                                    <% }%>
                                <% }%>
                            <% }%>
                        <% }else{%>
                            <%
                                if(arrayListUsers != null){
                            %>
                                <%
                                    for(int i=0; i < arrayListUsers.size(); i++){
                                %>
                                    <%
                                        if(arrayListUsers.get(i).getId() != userobjectfollowuser.getId()){
                                    %>
                                        <tr>
                                            <td><%=arrayListUsers.get(i).getUsername()%></td>
                                            <td><button class="btn btn-outline-primary" onclick="followuser(<%=userobjectfollowuser.getId()%>, <%=arrayListUsers.get(i).getId()%>)">Follow <i class="fa fa-check" aria-hidden="true"></i></button></td>
                                        </tr>
                                    <% }%>
                                <% }%>
                            <% }%>
                        <% }%>
                      <% }%>
                  </tbody>
              </table>
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>