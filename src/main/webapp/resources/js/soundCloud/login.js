SC.initialize({
  client_id: 'cc96dfbae2768d9291e729d107f89792',
  redirect_uri: 'http://localhost:6753/calvanodesignsource/soundcloud/callback.html'
});

// initiate auth popup
SC.connect().then(function() {
  return SC.get('/me');
}).then(function(me) {
  alert('Hello, ' + me.username);
});