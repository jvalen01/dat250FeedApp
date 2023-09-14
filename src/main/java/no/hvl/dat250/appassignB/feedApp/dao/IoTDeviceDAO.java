package no.hvl.dat250.appassignB.feedApp.dao;

import jakarta.persistence.EntityManager;
import  no.hvl.dat250.appassignB.feedApp.*;

import java.util.List;

public class IoTDeviceDAO extends AbstractDAO<IoTDevice, Long> {

    public IoTDeviceDAO(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<IoTDevice> getEntityClass() {
        return IoTDevice.class;
    }
}