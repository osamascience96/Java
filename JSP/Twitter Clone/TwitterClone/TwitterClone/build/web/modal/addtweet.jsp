<%@page import="Bean.User"%>
<div id="addtweet_modal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Add Tweet</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <%
              User userObject = (User) session.getAttribute("userObj");
          %>
          <div class="alert alert-danger" role="alert" id="alert_message" style="display: none;"></div>
          <form id="add_tweet_modal_form" action="tweet_controller" method="POST" enctype="multipart/form-data">
              <% if(userObject != null){ %>
                <input type="hidden" name="userid" value="<%=userObject.getId()%>">
              <% }%>
              <div class="form-group">
                  <textarea class="form-control" name="twet_text" id="twet_text" rows="10" cols="10" placeholder="Write Something to Post" required></textarea>
              </div>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">Upload</span>
                </div>
                <div class="custom-file">
                  <input type="file" class="custom-file-input" name="media" id="inputGroupFile01" required>
                  <label class="custom-file-label" for="inputGroupFile01">Choose Media</label>
                </div>
              </div>
              <input type="hidden" name="tweet_action" value="add">
              <button type="button" class="btn btn-outline-primary btn-block" onclick="check_add_tweet(document.getElementById('add_tweet_modal_form'))">Add Tweet</button>
          </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-outline-danger btn-block" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>