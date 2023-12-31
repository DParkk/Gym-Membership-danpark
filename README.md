# "Motivational Gym"
### Daniel Park (53807657)
###
- This application will
allow people to register a **Gym Membership** and encourage people
to work out by showing their **InBody Information** such as bmi.

- For registering a gym membership, a client will be prompted to enter their 
*name, height*, and *weight*. With those information, 
it will provide their BMI. Then clients will also
 know whether BMI score is in average or not. Also, there will be some advice depending 
on their InBody score.
- After entering their running distance, they will be able to check the runner with the most run-distance in the gym.

- This application is targeted to people who are trying to work out and want to
see their work-out progress with InBody information.
- This idea was tempting to me because when I visited a fancy gym in Korea,
the gym offered some free InBody information. So I thought it will be motivating for people to know their
InBody information anytime without any cost in gym. The advice they will be provided such as
recommended diet and work-out routine will motivate their work-out journey even more!
The part where they can compete with their run-distance will give more fun and competition between gym members.  

## "User stories"
- As a user, I want to be able to add an infinite amount of member's information to the member list.
- As a user, I want to see an interface where I can input my personal information for a gym registration.
- As a user, I want to see all the gym members' run distance.
- As a user, I want to see the first place for "run-distance" among the gym members.
- As a user, I want to be able to see my BMI score.
- As a user, I want to be able to check if my BMI score is in the average or not.
- As a user, I want to be able to save member's name to file (if I so choose)
- As a user, I want to be able to be able to load member's name from file (if I so choose)
- As a user, I want to sort members alphabetically.
- As a user, I want to clear members in memberList-panel.


### Citation
- Referred to "JsonSerializationDemo" to implement the JSON data.
- Referred to "LabelChanger" from edX page.
- Gym image from "https://play.google.com/store/apps/details?id=digifit.android.virtuagym.pro.danielsgym&hl=en_CA&gl=US"

### Phase 4: Task 2
- When the user hit "Quit", it will end the program and print the log.
- Add members to the list.
- Clear members in the list.
- Save members in the list.
- Load the saved members to the list.
- Sort members alphabetically.

### Phase 4: Task 3
- I would refactor the code in GymPanel(GUI) since there are lots of repetitive codes such as *'addActionListener'*.
- Also, *ActionPerformed* method in GUI class could have implemented some helper functions in order to prevent
MethodLength exceed.

