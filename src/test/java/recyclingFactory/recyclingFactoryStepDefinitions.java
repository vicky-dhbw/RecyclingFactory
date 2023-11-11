package recyclingFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.recycling.*;
import org.recycling.chainOfResponsibility.MetalSeparation;
import org.recycling.chainOfResponsibility.PaperSeparation;
import org.recycling.chainOfResponsibility.PlasticSeparation;
import org.recycling.chainOfResponsibility.SeparationProcess;
import org.recycling.observer.Sensor;
import org.recycling.visitor.Box;
import org.recycling.visitor.IRecyclable;
import org.recycling.visitor.RecyclableType;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class recyclingFactoryStepDefinitions {

    RecyclingFactory recyclingFactory;

    @Given("^I have a recycling factory with a conveyor$")
    public void I_have_a_recycling_factory() {
        recyclingFactory = new RecyclingFactory();
    }

    @When("^I install separation processes$")
    public void I_install_separation_processes() {
        recyclingFactory.installSeparationProcesses();
    }

    @Then("^The conveyor should have all the separation processes i have installed")
    public void conveyor_should_have_separation_processes() {
        for (SeparationProcess process : recyclingFactory.getConveyor().getSeparationProcesses()) {
            assertNotNull(process);
        }
    }

    @When("^I install Sensors$")
    public void when_I_install_sensors() {
        recyclingFactory.installSensors();
    }

    @Then("^Box of each separation process of the conveyor should have a sensor$")
    public void boxes_should_have_sensors() {
        for (SeparationProcess process : recyclingFactory.getConveyor().getSeparationProcesses()) {
            assertNotNull(process.getBox());
        }
    }

    @Given("^I have a control room with all the information about processes of the conveyor and a factory worker in the control room")
    public void i_have_a_control_room_and_a_worker() {
        recyclingFactory.setControlRoom(recyclingFactory.getConveyor().getSeparationProcesses());
        FactoryWorker worker = new FactoryWorker();
        recyclingFactory.getControlRoom().setWorker(worker);
    }

    @When("^I generate (\\d+) paper recyclables$")
    public void i_generate_paper_recyclables(int numberOfPaperGarbage) {
        Configuration.INSTANCE.setNumberOfRecyclablesOnConveyor(numberOfPaperGarbage);
        recyclingFactory.getConveyor().setRecyclables(RecyclablesGenerator.generateRandomPaperRecyclables());
    }

    @When("^I start the conveyor$")
    public void when_i_start_the_conveyor() {
        recyclingFactory.startConveyor();
    }

    @Then("^There should be (\\d+) number of filled bags in the factory containing only papers$")
    public void there_will_be_filled_bags_with_papers(int numberOfFilledBags) {
        assertEquals(numberOfFilledBags, recyclingFactory.getFilledBoxes().size());

        for (Box box : recyclingFactory.getFilledBoxes()) {

            for (IRecyclable recyclable : box.getRecyclables()) {
                assertEquals(recyclable.getType(), RecyclableType.P);
            }
        }
    }

    @Then("^The sensor of the paper separation box should setAlarm (\\d+) times$")
    public void the_sensor_should_set_alarm(int numberOfAlarms) {
        Conveyor conveyor = recyclingFactory.getConveyor();

        Sensor sensor = mock(Sensor.class);
        for (IRecyclable recyclable : conveyor.getRecyclables()) {

            Box box = conveyor.getPaperSeparationProcess().getBox();

            if (box.getCapacity() == Configuration.INSTANCE.numberOfRecyclablesInBox) {
                System.out.println("box hash: " + conveyor.getPaperSeparationProcess().getBox().hashCode());
                box.getSensor().setAlarm();
                sensor.setAlarm();
                recyclingFactory.getFilledBoxes().add(box);

            }
            conveyor.getMetalSeparationProcess().separate(recyclable);
            System.out.println("--------------------------------------------------");

        }

        verify(sensor, times(numberOfAlarms)).setAlarm();

    }

    @When("^I generate (\\d+) random recyclables$")
    public void i_generate_random_recyclables(int numberOfPaperGarbage) {
        Configuration.INSTANCE.setNumberOfRecyclablesOnConveyor(numberOfPaperGarbage);
        recyclingFactory.getConveyor().setRecyclables(RecyclablesGenerator.generateRandomPaperRecyclables());
    }

    @Then("^Each process should separate recyclables that they are responsible for")
    public void each_process_should_separate_recyclables_that_they_are_responsible_for() {
        for (SeparationProcess process : recyclingFactory.getConveyor().getSeparationProcesses()) {
            if (process instanceof PaperSeparation) {
                for (IRecyclable recyclable : process.getBox().getRecyclables()) {
                    assertSame(recyclable.getType(), RecyclableType.P);
                }
            }
            if (process instanceof PlasticSeparation) {
                for (IRecyclable recyclable : process.getBox().getRecyclables()) {
                    assertSame(recyclable.getType(), RecyclableType.S);
                }
            }
            if (process instanceof MetalSeparation) {
                for (IRecyclable recyclable : process.getBox().getRecyclables()) {
                    assertSame(recyclable.getType(), RecyclableType.M);
                }
            }
        }
    }
}
