package e.doc.service.buildersm;

import e.doc.domain.providerctt.blrwbl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BLRWBLParser {

    //XMLStreamReader reader = null;
    BLRWBL blrwbl = null;
    DeliveryNote deliveryNote = null;
    private static Logger logger = LogManager.getLogger(BLRWBLParser.class);


    public BLRWBL parseBLRWBL(File f) {
        XMLStreamReader reader = null;
        FileInputStream fis = null;
        //logger.info("parseBLRWBL f.getAbsolutePath() - " + f.getAbsolutePath());
        try {
            fis = new FileInputStream(f.getAbsolutePath());
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            reader = xmlInputFactory.createXMLStreamReader(fis);
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        logger.debug("START_ELEMENT - " + event + " reader.getLocalName() - " + reader.getLocalName());
                        if ("BLRWBL".equals(reader.getLocalName())) {
                            blrwbl = new BLRWBL();
                            break;
                        }
                        if ("DeliveryNote".equals(reader.getLocalName())) {
                            deliveryNote = new DeliveryNote();
                            readDeliveryNote(reader);
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        logger.debug("END_ELEMENT - " + event + " reader.getLocalName() - " + reader.getLocalName());

                        switch (reader.getLocalName()) {
                            case "BLRWBL":
                                //reader.close();
                                //fis.close();
                                return blrwbl;
                        }
                        break;

                    case XMLStreamConstants.START_DOCUMENT:
                        logger.debug("START_DOCUMENT - " + event + " reader.getLocalName() - " + reader.getText());
                        blrwbl = new BLRWBL();
                        break;
                }
            }
            //reader.close();
            //fis.close();
        } catch (XMLStreamException e) {

            logger.debug("XMLStreamException" + e);
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            logger.debug("FileNotFoundException" + e);
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
                fis.close();

            } catch (XMLStreamException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return blrwbl;
    }

    private void readDeliveryNote(XMLStreamReader reader) throws XMLStreamException {
        String tagContent = null;
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    logger.debug("START_ELEMENT - " + event + " reader.getLocalName() - " + reader.getLocalName());
                    if ("Shipper".equals(reader.getLocalName())) {
                        readShipper(reader, new Shipper());
                    }
                    if ("Receiver".equals(reader.getLocalName())) {
                        readReceiver(reader, new Receiver());
                    }
                    if ("ShipFrom".equals(reader.getLocalName())) {
                        readShipFrom(reader, new ShipFrom());
                    }
                    if ("ShipTo".equals(reader.getLocalName())) {
                        readShipTo(reader, new ShipTo());
                    }
                    if ("Total".equals(reader.getLocalName())) {
                        readTotal(reader, new Total());
                    }
                    if ("DespatchAdviceLogisticUnitLineItem".equals(reader.getLocalName())) {
                        readLineItem(reader, new ArrayList<LineItem>());
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    logger.debug("CHARACTERS - " + event + " reader.getLocalName() - " + reader.getText());
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    logger.debug("END_ELEMENT - " + event + " reader.getLocalName() - " + reader.getLocalName());
                    switch (reader.getLocalName()) {
                        case "DeliveryNoteID":
                            deliveryNote.setDeliveryNoteID(tagContent);
                            break;
                        case "DeliveryNoteDate":
                            deliveryNote.setDeliveryNoteDate(tagContent);
                            break;
                        case "CreationDateTime":
                            deliveryNote.setCreationDateTime(tagContent);
                            break;
                        case "OrderID":
                            deliveryNote.setOrderID(tagContent);
                            break;
                        case "DeliveryNote":
                            blrwbl.setDeliveryNote(deliveryNote);
                            return;
                    }
                    break;
            }
        }
    }

    private void readShipFrom(XMLStreamReader reader, ShipFrom shipFrom) throws XMLStreamException {
        String tagContent = null;
        //ShipTo shipTo = null;
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    logger.debug("START_ELEMENT - " + event + " reader.getLocalName() - " + reader.getLocalName());
                    break;

                case XMLStreamConstants.CHARACTERS:
                    logger.debug("CHARACTERS - " + event + " reader.getLocalName() - " + reader.getText());
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    logger.debug("END_ELEMENT - " + event + " reader.getLocalName() - " + reader.getLocalName());
                    switch (reader.getLocalName()) {
                        case "GLN":
                            shipFrom.setGLN(tagContent);
                            break;
                        case "Address":
                            shipFrom.setAddress(tagContent);
                            break;
                        case "Contact":
                            shipFrom.setContact(tagContent);
                            break;
                        case "ShipFrom":
                            deliveryNote.setShipFrom(shipFrom);
                            return;
                    }
                    break;
            }
        }
    }

    private void readShipTo(XMLStreamReader reader, ShipTo shipTo) throws XMLStreamException {
        String tagContent = null;
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    logger.debug("START_ELEMENT - " + event + " reader.getLocalName() - " + reader.getLocalName());
                    break;

                case XMLStreamConstants.CHARACTERS:
                    logger.debug("CHARACTERS - " + event + " reader.getLocalName() - " + reader.getText());
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    logger.debug("END_ELEMENT - " + event + " reader.getLocalName() - " + reader.getLocalName());
                    switch (reader.getLocalName()) {
                        case "GLN":
                            shipTo.setGLN(tagContent);
                            break;
                        case "Address":
                            shipTo.setAddress(tagContent);
                            break;
                        case "ShipTo":
                            deliveryNote.setShipTo(shipTo);
                            return;
                    }
                    break;
            }
        }
    }

    private void readShipper(XMLStreamReader reader, Shipper shipper) throws XMLStreamException {
        String tagContent = null;
        //ShipTo shipTo = null;
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {

                case XMLStreamConstants.CHARACTERS:
                    logger.debug("CHARACTERS - " + event + " reader.getLocalName() - " + reader.getText());
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    logger.debug("END_ELEMENT - " + event + " reader.getLocalName() - " + reader.getLocalName());
                    switch (reader.getLocalName()) {
                        case "GLN":
                            shipper.setGLN(tagContent);
                            break;
                        case "Shipper":
                            deliveryNote.setShipper(shipper);
                            return;
                    }
                    break;
            }

        }
    }

    private void readReceiver(XMLStreamReader reader, Receiver receiver) throws XMLStreamException {
        String tagContent = null;
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {

                case XMLStreamConstants.CHARACTERS:
                    logger.debug("CHARACTERS - " + event + " reader.getLocalName() - " + reader.getText());
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    logger.debug("END_ELEMENT - " + event + " reader.getLocalName() - " + reader.getLocalName());
                    switch (reader.getLocalName()) {
                        case "GLN":
                            receiver.setGLN(tagContent);
                            break;
                        case "Receiver":
                            deliveryNote.setReceiver(receiver);
                            return;
                    }
                    break;
            }
        }
    }

    private void readTotal(XMLStreamReader reader, Total total) throws XMLStreamException {
        String tagContent = null;
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {

                case XMLStreamConstants.CHARACTERS:
                    logger.debug("CHARACTERS - " + event + " reader.getLocalName() - " + reader.getText());
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    logger.debug("END_ELEMENT - " + event + " reader.getLocalName() - " + reader.getLocalName());
                    switch (reader.getLocalName()) {
                        case "TotalAmount":
                            total.setTotalAmount(new BigDecimal(tagContent));
                            break;
                        case "Total":
                            deliveryNote.setTotal(total);
                            return;
                    }
                    break;
            }
        }
    }

    private void readLineItem(XMLStreamReader reader, List<LineItem> lineItems) throws XMLStreamException {
        LineItem li = null;
        String tagContent = null;
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {

                case XMLStreamConstants.START_ELEMENT:
                    logger.debug("START_ELEMENT - " + event + " reader.getLocalName() - " + reader.getLocalName());
                    if ("LineItem".equals(reader.getLocalName())) {
                        li = new LineItem();
                        break;
                    }
                    break;


                case XMLStreamConstants.CHARACTERS:
                    logger.debug("CHARACTERS - " + event + " reader.getLocalName() - " + reader.getText());
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    logger.debug("END_ELEMENT - " + event + " reader.getLocalName() - " + reader.getLocalName());
                    switch (reader.getLocalName()) {
                        case "LineItemNumber":
                            li.setLineItemNumber(tagContent);
                            break;
                        case "LineItemPrice":
                            li.setLineItemPrice(new BigDecimal(tagContent));
                            break;
                        case "TaxRate":
                            li.setTaxRate(new BigDecimal(tagContent));
                            break;
                        case "QuantityDespatched":
                            li.setQuantityDespatched(new BigDecimal(tagContent));
                            break;
                        case "LineItemAmount":
                            li.setLineItemAmount(new BigDecimal(tagContent));
                            break;
                        case "LineItemAmountWithoutCharges":
                            li.setLineItemAmountWithoutCharges(new BigDecimal(tagContent));
                            break;
                        case "LineItemID":
                            li.setLineItemID(tagContent);
                            break;
                        case "LineItemAmountCharges":
                            li.setLineItemAmountCharges(new BigDecimal(tagContent));
                            break;
                        case "LineItemName":
                            li.setLineItemName(tagContent);
                            break;
                        case "LineItem":
                            lineItems.add(li);
                            break;
                        case "DespatchAdviceLogisticUnitLineItem":
                            deliveryNote.setLineItem(lineItems);
                            return;
                    }
                    break;
            }
        }
    }
}
